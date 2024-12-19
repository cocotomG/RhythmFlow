package com.a23plan.music.service.Impl;

import com.a23plan.music.entity.Singer;
import com.a23plan.music.mapper.SingerMapper;
import com.a23plan.music.service.SingerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author:  err
 * @Description:
 * @return:
 * @Date:  2024/6/11 13:49
 */
@Service
public class SingerServiceImpl extends ServiceImpl<SingerMapper, Singer> implements SingerService {
    @Resource
    private SingerMapper singerMapper;

    @Override
    public Singer getSingerDetail(Integer singerId) {
        return singerMapper.getSingerDetail(singerId);
    }

    @Override
    public List<Map<String, Object>> getSingBySex() {
        return singerMapper.getSingBySex();
    }
}
