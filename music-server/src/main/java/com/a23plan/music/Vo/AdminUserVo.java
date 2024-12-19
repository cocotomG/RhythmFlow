package com.a23plan.music.Vo;

import lombok.Data;

/**
 * @Author:  err
 * @Description: 
 * @return: 
 * @Date:  2024/6/11 13:48
 */
@Data
public class AdminUserVo {

    /**
     * 管理员id
     */
    private Integer adminId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 说明
     */
    private String password;

    /**
     * 旧密码
     */
    private String oldPassword;

    /**
     * 验证码
     */
    private String code;
}
