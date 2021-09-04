package com.xiefei.bandportal.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiefei.bandcommon.exception.Asserts;
import com.xiefei.bandcommon.service.RedisService;
import com.xiefei.bandportal.entity.User;
import com.xiefei.bandportal.mapper.RoleMapper;
import com.xiefei.bandportal.mapper.UserMapper;
import com.xiefei.bandportal.service.IUserCacheService;
import com.xiefei.bandportal.service.IUserService;
import io.netty.util.internal.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.xiefei.bandcommon.dto.UserDTO;

import java.lang.annotation.ElementType;
import java.sql.Wrapper;
import java.util.List;
import java.util.Random;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author AutoGenerator
 * @since 2021-09-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService, UserDetailsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private RedisService redisService;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private IUserCacheService userCacheService;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    public int register(UserDTO user, String authCode) {
        //校对验证码
        if(StringUtil.isNullOrEmpty(authCode)){
            Asserts.failed("验证码不能为空！");
        }
        String rightAuthCode = (String) redisService.get(user.getTelephone());
        if(!rightAuthCode.equals(authCode)){
            Asserts.failed("验证码错误！");
        }
        //首先查找数据库中有没有这个用户
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.select("id","username","password","telephone","nickname","city","create_time","birthday","favorite_style","favorite_band","status","imgine","sex");
        List<User> users = baseMapper.selectList(wrapper);
        for(User u : users){
            if (user.getTelephone().equals(u.getTelephone())){
                Asserts.failed("该用户已存在");
            }
        }
        //如果没有,则进行注册
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setNickname(user.getNickname());
        newUser.setTelephone(user.getTelephone());
        newUser.setSex(user.getSex());
        int insert = baseMapper.insert(newUser);
        return insert;
    }

    @Override
    public String getAuthCode(String telePhone) {
        StringBuilder sb = new StringBuilder();
        Random rd = new Random();
        for(int i=0;i<6;i++){
            int num = rd.nextInt(10);
            sb.append(num);
        }
        String authCode = sb.toString();
        //存入redis缓存中
        redisService.set(telePhone,authCode);
        return authCode;
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        //已经根据用户名查出用户了
        UserDetails userDetails = loadUserByUsername(username);
        if(!passwordEncoder.matches(password,userDetails.getPassword())){
            throw new BadCredentialsException("密码不正确");
        }
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolderStrategy securityContextHolderStrategy;

//        loadUserByUsername(username)
        return null;
    }

    @Override
    public User getByUsername(String username) {
        User user = userCacheService.getUser(username);
        if(user!=null){
            return user;
        }

        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("username",username);
        user = baseMapper.selectOne(wrapper);
        if(user!=null){
            return user;
        }
        return null;

    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getByUsername(username);
        if(user!=null){
            return user;
        }
        else {
            throw new UsernameNotFoundException("用户名或密码错误");
        }

    }
}
