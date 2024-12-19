package com.a23plan.music.service.Impl;

import com.a23plan.music.entity.Collect;
import com.a23plan.music.mapper.CollectMapper;
import com.a23plan.music.service.CollectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author:  err
 * @Description:
 * @return:
 * @Date:  2024/6/11 13:49
 */
@Service
public class CollectServiceImpl extends ServiceImpl<CollectMapper, Collect> implements CollectService {
    @Resource
    private CollectMapper collectMapper;

    @Override
    public List<Integer> getCollectList(Integer accountId) {
        return collectMapper.getCollectList(accountId);
    }
}
