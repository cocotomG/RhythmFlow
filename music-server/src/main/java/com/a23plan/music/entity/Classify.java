package com.a23plan.music.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author:  err
 * @Description:
 * @return:
 * @Date:  2024/6/11 13:46
 */
@Data
public class Classify implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 歌单分类id
     */
    @TableId(value = "classify_id", type = IdType.AUTO)
    private Integer classifyId;

    /**
     * 歌单分类名
     */
    private String classifyName;
}
