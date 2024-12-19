package com.a23plan.music.service;

import com.a23plan.music.entity.SongmenuList;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @Author:  err
 * @Description:
 * @return:
 * @Date:  2024/6/11 13:48
 */
public interface SongmenuListService extends IService<SongmenuList> {
    /**
     *  根据歌单id获取歌单下的歌曲
     * @param songmenuId
     * @return
     */
    List<Integer> getSongMenu(Integer songmenuId);
}
