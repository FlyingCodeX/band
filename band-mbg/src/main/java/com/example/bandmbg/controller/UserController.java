package com.example.bandmbg.controller;


import com.example.bandmbg.entity.User;
import com.example.bandmbg.service.IUserService;
import com.xiefei.bandcommon.api.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author AutoGenerator
 * @since 2021-09-01
 */
@RestController
@RequestMapping("/user")
@Api(value = "用户接口")
public class UserController {
    @Autowired
    IUserService userService;


    public CommonResult<User> register(User user){
        userService.register(user);
        return CommonResult.success(user,"注册成功");
    }


}