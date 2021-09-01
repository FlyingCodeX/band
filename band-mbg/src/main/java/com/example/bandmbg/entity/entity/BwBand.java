package com.example.bandmbg.entity.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author AutoGenerator
 * @since 2021-09-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="BwBand对象", description="")
public class BwBand implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "乐队名")
    private String name;

    @ApiModelProperty(value = "乐队成员")
    private String members;

    @ApiModelProperty(value = "乐队所在地区")
    private String religion;

    @ApiModelProperty(value = "乐队音乐风格")
    private String style;

    @ApiModelProperty(value = "乐队所属公司")
    private String company;

    @ApiModelProperty(value = "乐队创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "乐队专辑")
    private String album;

    @ApiModelProperty(value = "乐队简介")
    private String introduction;

    @ApiModelProperty(value = "乐队微博")
    private String vblog;

    @ApiModelProperty(value = "乐队介绍图片	")
    private String imagine;


}
