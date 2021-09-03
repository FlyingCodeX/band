package com.xiefei.bandportal.controller;


import com.xiefei.bandportal.entity.Band;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/band")
@Api(tags = "乐队接口")
public class BandController {

    @ApiOperation(value = "展示乐队具体信息")
    @GetMapping("/bandDetail")
    Band bandDetail(String bandName){
        System.out.println("================访问通过======================");
        return null;
    }


}
