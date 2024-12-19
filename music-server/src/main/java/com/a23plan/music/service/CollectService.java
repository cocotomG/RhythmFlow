package com.a23plan.music.service;

import com.a23plan.music.entity.Collect;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @Author:  err
 * @Description:
 * @return:
 * @Date:  2024/6/11 13:47
 */
public interface CollectService extends IService<Collect> {

    /**
     * 通过accountId查询收藏的歌曲id
     * @param accountId
     * @return
     */
    List<Integer> getCollectList(Integer accountId);
}
