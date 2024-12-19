package com.a23plan.music.service;

import com.a23plan.music.entity.Account;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * @Author:  err
 * @Description:
 * @return:
 * @Date:  2024/6/11 13:48
 */
public interface AccountService extends IService<Account> {
    /**
     * 根据邮箱查询账号的方法
     * @param email
     * @return void
     */
    Account getAccount(String email);

    /**
     * 通过id查询账号详细信息
     * @param accountId
     * @return
     */
    Account accountDetail(Integer accountId);

    /**
     * 分组统计用户不同性别数量
     * @return
     */
    List<Map<String, Object>> getAccountBYSex();
}
