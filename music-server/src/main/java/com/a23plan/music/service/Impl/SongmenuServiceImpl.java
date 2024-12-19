package com.a23plan.music.service.Impl;

import com.a23plan.music.entity.Classify;
import com.a23plan.music.entity.Songmenu;
import com.a23plan.music.mapper.SongmenuMapper;
import com.a23plan.music.service.SongmenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author:  err
 * @Description: 
 * @return: 
 * @Date:  2024/6/11 13:48
 */
@Service
public class SongmenuServiceImpl extends ServiceImpl<SongmenuMapper, Songmenu> implements SongmenuService {
    @Resource
    private SongmenuMapper songmenuMapper;
    @Override
    public List<Classify> getClassifyCount() {
        return songmenuMapper.getClassifyCount();
    }
}
