package com.xiefei.bandportal.controller;


import com.xiefei.bandcommon.api.CommonResult;
import com.xiefei.bandportal.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.xiefei.bandcommon.dto.UserDTO;

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
@Api(tags = "用户接口")
public class UserController {
    @Autowired
    IUserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @ApiOperation(value = "用户注册接口")
    @GetMapping("/register")
    public CommonResult<UserDTO> register(UserDTO user, String authCode){
        userService.register(user,authCode);
        return CommonResult.success(user,"注册成功");
    }

    @ApiOperation(value = "获取验证码")
    @GetMapping("/getAuthCode")
    public CommonResult<String> getAuthCode(String telePhone){
        String authCode = userService.getAuthCode(telePhone);
        return CommonResult.success(authCode);
    }

    @ApiOperation(value = "用户登录")
    @GetMapping("/login")
    public CommonResult<String> login(String username,String password){
        String token = userService.login(username, password);

//        userService
        return CommonResult.success(token);
    }



}
