package com.a23plan.music.controller.admin;

import cn.hutool.core.util.StrUtil;
import com.a23plan.music.Vo.PageParams;
import com.a23plan.music.entity.Account;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.a23plan.music.common.CommonResult;
import com.a23plan.music.service.AccountService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @Author:  err
 * @Description:
 * @return:
 * @Date:  2024/6/11 13:44
 */
@Validated
@RestController
@RequestMapping("/api")
public class UserController {
    @Resource
    private AccountService accountService;

    /**
     * 获取所有用户
     * @return
     */
    @GetMapping("/account")
    public CommonResult<IPage<Account>> getAccountList(@Valid PageParams params){
        IPage<Account> page = new Page<Account>(params.getCurrentPage(),10);
        if(StrUtil.isEmpty(params.getKeyword())){
            return CommonResult.success(accountService.page(page));
        }
        return CommonResult.success(accountService.page(page,new QueryWrapper<Account>().eq("username",params.getKeyword())));
    }

    /**
     * 修改用户状态
     * @param account
     * @return
     */
    @PostMapping("/forbid")
    public CommonResult<String> forbidAccount(@RequestBody Account account){
        boolean result = accountService.updateById(account);
        return result ? CommonResult.success() : CommonResult.faild();
    }
}
