package com.xiefei.bandportal.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiefei.bandcommon.exception.Asserts;
import com.xiefei.bandcommon.service.RedisService;
import com.xiefei.bandportal.entity.User;
import com.xiefei.bandportal.mapper.UserMapper;
import com.xiefei.bandportal.service.IUserService;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    RedisService redisService;

    @Override
    public int register(User user,String authCode) {
        if(!StringUtil.isNullOrEmpty(authCode)){
            Asserts.failed("验证码不能为空！");
        }
        String rightAuthCode = (String) redisService.get(user.getTelephone());
        if(!rightAuthCode.equals(authCode)){
            Asserts.failed("验证码错误！");
        }

        //首先查找数据库中有没有这个用户
        List<User> users = baseMapper.selectList(null);
        for(User u : users){
            if (u.equals(user)){
                return -1;
            }
        }
        //如果没有,则进行注册
        int insert = baseMapper.insert(user);
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
}