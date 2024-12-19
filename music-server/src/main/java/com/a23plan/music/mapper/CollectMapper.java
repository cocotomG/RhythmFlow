package com.a23plan.music.mapper;

import com.a23plan.music.entity.Collect;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author:  err
 * @Description:
 * @return:
 * @Date:  2024/6/11 13:47
 */
@Mapper
public interface CollectMapper extends BaseMapper<Collect> {

    /**
     * 通过accountId查询收藏的歌曲id
     * @param accountId
     * @return List
     */
    @Select("select song_id from collect where account_id=#{accountId}")
    List<Integer> getCollectList(Integer accountId);
}
