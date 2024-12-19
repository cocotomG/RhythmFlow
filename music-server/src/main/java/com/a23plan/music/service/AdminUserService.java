package com.a23plan.music.service;

import com.a23plan.music.entity.AdminUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Author:  err
 * @Description:
 * @return:
 * @Date:  2024/6/11 13:47
 */
public interface AdminUserService extends IService<AdminUser> {
    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    AdminUser getAdminUser(String username);
}
