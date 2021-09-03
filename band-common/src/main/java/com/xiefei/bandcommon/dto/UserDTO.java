package com.xiefei.bandcommon.dto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * @author faye
 * @create 2021-09-2021/9/2-9:50
 */
@Data
@ApiModel(value="UserDto对象")
public class UserDTO {

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "用户密码")
    private String password;

    @ApiModelProperty(value = "用户电话")
    private String telephone;

    @ApiModelProperty(value = "用户昵称")
    private String nickname;

    @ApiModelProperty(value = "用户性别")
    private String sex;

}
