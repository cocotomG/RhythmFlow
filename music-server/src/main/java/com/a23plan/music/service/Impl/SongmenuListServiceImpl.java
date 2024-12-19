package com.a23plan.music.service.Impl;

import com.a23plan.music.entity.SongmenuList;
import com.a23plan.music.mapper.SongmenuListMapper;
import com.a23plan.music.service.SongmenuListService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author:  err
 * @Description: 
 * @return: 
 * @Date:  2024/6/11 13:51
 */
@Service
public class SongmenuListServiceImpl extends ServiceImpl<SongmenuListMapper, SongmenuList> implements SongmenuListService {
    @Resource
    private SongmenuListMapper songmenuListMapper;

    @Override
    public List<Integer> getSongMenu(Integer songmenuId) {
        return songmenuListMapper.getSongMenu(songmenuId);
    }
}
