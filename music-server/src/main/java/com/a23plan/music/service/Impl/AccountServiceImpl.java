package com.a23plan.music.service.Impl;

import com.a23plan.music.entity.Account;
import com.a23plan.music.mapper.AccountMapper;
import com.a23plan.music.service.AccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author:  err
 * @Description:
 * @return:
 * @Date:  2024/6/11 13:48
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {
    @Resource
    private AccountMapper accountMapper;

    @Override
    public Account getAccount(String email) {
        return accountMapper.getAccount(email);
    }

    @Override
    public Account accountDetail(Integer accountId) {
        return accountMapper.getAccountDetail(accountId);
    }

    @Override
    public List<Map<String, Object>> getAccountBYSex() {
        return accountMapper.getAccountBySex();
    }
}
