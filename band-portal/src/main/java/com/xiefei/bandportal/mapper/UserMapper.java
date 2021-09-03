package com.xiefei.bandportal.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiefei.bandportal.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author AutoGenerator
 * @since 2021-09-01
 */
public interface UserMapper extends BaseMapper<User> {

    @Select("SELECT *　FROM bw_user WHERE username = #{username} ")
    List<User> getUserByUsername(String username);

}
