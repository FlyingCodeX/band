package com.xiefei.bandportal.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiefei.bandcommon.exception.Asserts;
import com.xiefei.bandcommon.service.RedisService;
import com.xiefei.bandportal.entity.User;
import com.xiefei.bandportal.mapper.RoleMapper;
import com.xiefei.bandportal.mapper.UserMapper;
import com.xiefei.bandportal.service.IUserService;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.xiefei.bandcommon.dto.UserDTO;

import java.lang.annotation.ElementType;
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

    @Autowired
    private RedisService redisService;

    @Autowired
    private RoleMapper roleMapper;

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
        List<User> users = baseMapper.selectList(null);
        for(User u : users){
            if (user.getTelephone().equals(u.getTelephone())){
                Asserts.failed("该用户已存在");
            }
        }
        //如果没有,则进行注册
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
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
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List<User> users = baseMapper.getUserByUsername(s);

        if(users.size()==0){
            throw new UsernameNotFoundException("该用户不存在！");
        }
        else {
            users.get(0).setRoles(roleMapper.getRoleByUserId(users.get(0).getId()));
        }
        return null;
    }
}
