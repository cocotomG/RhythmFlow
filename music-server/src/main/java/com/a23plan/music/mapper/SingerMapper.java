package com.a23plan.music.mapper;

import com.a23plan.music.entity.Singer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @Author:  err
 * @Description:
 * @return:
 * @Date:  2024/6/11 13:46
 */
@Mapper
public interface SingerMapper extends BaseMapper<Singer> {

    /**
     * 查询歌手详情
     * @param singerId
     * @return
     */
    @Results({
            @Result(property = "singerId",column = "singer_id",id = true),
            @Result(property = "name",column = "name"),
            @Result(property = "sex",column = "sex"),
            @Result(property = "pic",column = "pic"),
            @Result(property = "birth",column = "birth"),
            @Result(property = "address",column = "address"),
            @Result(property = "introduction",column = "introduction")
    })
    @Select("select * from singer where singer_id=#{singerId}")
    Singer getSingerDetail(Integer singerId);

    /**
     * 分组统计歌手不同性别数量
     * @return
     */
    @Select("select sex,count(sex) type from singer group by sex")
    List<Map<String, Object>> getSingBySex();
}
