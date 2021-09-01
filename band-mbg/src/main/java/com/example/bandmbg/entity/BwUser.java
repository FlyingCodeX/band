package com.example.bandmbg.entity;

import java.time.LocalDate;
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
@ApiModel(value="BwUser对象", description="")
public class BwUser implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "用户密码")
    private String password;

    @ApiModelProperty(value = "用户电话")
    private String telephone;

    @ApiModelProperty(value = "用户昵称")
    private String nickname;

    @ApiModelProperty(value = "用户所在城市")
    private String city;

    @ApiModelProperty(value = "用户创建时间")
    private LocalDate createTime;

    @ApiModelProperty(value = "用户生日")
    private LocalDate birthday;

    @ApiModelProperty(value = "用户偏好风格")
    private String favoriteStyle;

    @ApiModelProperty(value = "用户偏好乐队")
    private String favoriteBand;

    @ApiModelProperty(value = "用户状态")
    private Integer status;

    @ApiModelProperty(value = "用户头像")
    private String imgine;


}
