package com.xiefei.bandportal.controller;


import com.xiefei.bandcommon.api.CommonResult;
import com.xiefei.bandportal.entity.User;
import com.xiefei.bandportal.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
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

    @ApiOperation(tags = "用户注册接口",value = "用户测试接口")
    @GetMapping("/register")
    public CommonResult<User> register(User user,String authCode){
        userService.register(user,authCode);
        return CommonResult.success(user,"注册成功");
    }

    @ApiOperation(tags = "获取验证码",value = "获取验证码")
    @GetMapping("/getAuthCode")
    public CommonResult<String> getAuthCode(String telePhone){
        String authCode = userService.getAuthCode(telePhone);
        return CommonResult.success(authCode);
    }



}
