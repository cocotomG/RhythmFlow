package com.a23plan.music.Vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Author:  err
 * @Description: 
 * @return: 
 * @Date:  2024/6/11 13:48
 */
@Data
public class PageParams {
    /**
     * 当前页
     */
    @NotNull(message = "当前页字段不能为空")
    private Integer currentPage;

    /**
     * 歌手类型
     */
    private Integer sex;

    /**
     * 歌单分类
     */
    private Integer classifyId;

    /**
     * 搜索关键字
     */
    private String keyword;

    private Integer accountId;

    private Integer singerId;

    private Integer songmenuId;
    /**
     *  type 等于0 代表歌手类型，1代表歌单类型
     */
    private Integer type;
}
