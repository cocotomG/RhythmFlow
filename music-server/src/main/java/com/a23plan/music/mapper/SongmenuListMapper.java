package com.a23plan.music.mapper;

import com.a23plan.music.entity.SongmenuList;
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
public interface SongmenuListMapper extends BaseMapper<SongmenuList> {

    /**
     * 根据歌单id获取歌单下的歌曲
     * @param songmenuId
     * @return
     */
    @Select("select song_id from songmenu_list where songmenu_id=#{songmenuId}")
    List<Integer> getSongMenu(Integer songmenuId);
}
