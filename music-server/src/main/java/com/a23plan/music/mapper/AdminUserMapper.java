package com.a23plan.music.mapper;

import com.a23plan.music.entity.AdminUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author:  err
 * @Description:
 * @return:
 * @Date:  2024/6/11 13:46
 */
@Mapper
public interface AdminUserMapper extends BaseMapper<AdminUser> {
    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    @Select("select admin_id adminId,username from admin_user where username=#{username}")
    AdminUser getAdminUser(String username);
}
