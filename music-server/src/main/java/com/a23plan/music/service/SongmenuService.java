package com.a23plan.music.service;

import com.a23plan.music.entity.Classify;
import com.a23plan.music.entity.Songmenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @Author:  err
 * @Description:
 * @return:
 * @Date:  2024/6/11 13:48
 */
public interface SongmenuService extends IService<Songmenu> {
    /**
     * 查询歌单类型数量
     * @return
     */
    List<Classify> getClassifyCount();
}
