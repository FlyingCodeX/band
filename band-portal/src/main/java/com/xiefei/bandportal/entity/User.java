package com.xiefei.bandportal.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



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
@TableName("bw_user")
@ApiModel(value="User对象", description="")
public class User implements Serializable, UserDetails {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id",type = IdType.AUTO)
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

    @ApiModelProperty(value = "用户性别")
    private String sex;

    @ApiModelProperty(value = "用户权限集合")
    private List<Role> roles;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        for (Role role : roles){
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
