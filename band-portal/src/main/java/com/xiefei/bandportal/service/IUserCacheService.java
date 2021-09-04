package com.xiefei.bandportal.service;

import com.xiefei.bandportal.entity.User;

/**
 * @author faye
 * @create 2021-09-2021/9/4-10:29
 */
public interface IUserCacheService {

    User getUser(String username);
}
