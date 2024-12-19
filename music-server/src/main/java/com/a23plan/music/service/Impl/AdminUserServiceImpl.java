package com.a23plan.music.service.Impl;

import com.a23plan.music.entity.AdminUser;
import com.a23plan.music.mapper.AdminUserMapper;
import com.a23plan.music.service.AdminUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author:  err
 * @Description:
 * @return:
 * @Date:  2024/6/11 13:48
 */
@Service
public class AdminUserServiceImpl extends ServiceImpl<AdminUserMapper, AdminUser> implements AdminUserService {
    @Resource
    private AdminUserMapper adminUserMapper;

    public AdminUser getAdminUser(String username){
        return adminUserMapper.getAdminUser(username);
    }
}
