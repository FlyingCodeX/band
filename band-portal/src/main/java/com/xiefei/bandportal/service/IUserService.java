package com.xiefei.bandportal.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.xiefei.bandportal.entity.User;
import com.xiefei.bandcommon.dto.*;
/**
 * <p>
 *  服务类
 * </p>
 *
 * @author AutoGenerator
 * @since 2021-09-01
 */
public interface IUserService extends IService<User> {

    int register(UserDTO user, String authCode);

    String getAuthCode(String telePhone);
}
