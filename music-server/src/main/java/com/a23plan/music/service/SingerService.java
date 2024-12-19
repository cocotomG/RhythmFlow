package com.a23plan.music.service;

import com.a23plan.music.entity.Singer;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * @Author:  err
 * @Description:
 * @return:
 * @Date:  2024/6/11 13:47
 */
public interface SingerService extends IService<Singer> {

    /**
     * 查询歌手详情
     * @param singerId
     * @return
     */
    Singer getSingerDetail(Integer singerId);

    /**
     * 分组统计歌手不同性别数量
     * @return
     */
    List<Map<String, Object>> getSingBySex();
}
