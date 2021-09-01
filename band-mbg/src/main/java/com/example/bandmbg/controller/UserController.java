package com.example.bandmbg.controller;


import com.example.bandmbg.entity.User;
import com.example.bandmbg.service.IUserService;
import com.xiefei.bandcommon.api.CommonResult;
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
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping("/register")
    public CommonResult<User> register(User user){


        return CommonResult.success(user,"注册成功");
    }


}
