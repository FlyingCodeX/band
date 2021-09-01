package com.example.bandmbg.service.impl;

import com.example.bandmbg.entity.User;
import com.example.bandmbg.mapper.UserMapper;
import com.example.bandmbg.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public int register(User user) {
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
}
