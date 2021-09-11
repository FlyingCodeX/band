package com.xiefei.bandportal.mapper;


import com.baomidou.mybatisplus.core.injector.methods.SelectById;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiefei.bandportal.entity.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author AutoGenerator
 * @since 2021-09-03
 */
public interface RoleMapper extends BaseMapper<Role> {

    @Select("SELECT * FROM bw_role r,bw_user_role ur where ur.id = #{id} and ur.rid = r.id")
    List<Role> getRoleByUserId(int id);

}
