package com.a23plan.music.mapper;

import com.a23plan.music.entity.Classify;
import com.a23plan.music.entity.Songmenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author:  err
 * @Description:
 * @return:
 * @Date:  2024/6/11 13:47
 */
@Mapper
public interface SongmenuMapper extends BaseMapper<Songmenu> {
    /**
     * 查询歌单类型数量
     * @return
     */
    @Select("select  c.classify_name classifyName,count(c.classify_id) classifyId from classify c left join songmenu s " +
            "on c.classify_id = s.classify_id group by c.classify_id")
    List<Classify> getClassifyCount();
}
