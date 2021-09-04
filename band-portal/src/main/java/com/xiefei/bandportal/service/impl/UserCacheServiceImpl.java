package com.xiefei.bandportal.service.impl;

import com.xiefei.bandcommon.service.RedisService;
import com.xiefei.bandportal.entity.User;
import com.xiefei.bandportal.service.IUserCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author faye
 * @create 2021-09-2021/9/4-10:30
 */
@Service
public class UserCacheServiceImpl implements IUserCacheService {
    @Autowired
    RedisService redisService;

    @Value("${redis.database}")
    private String REDIS_DATABASE;

    @Value("${redis.key.member}")
    private String REDIS_KEY_MEMBER;

    @Override
    public User getUser(String username) {
        User user = (User) redisService.get(username);
        return user;
    }
}
