package com.a23plan.music.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Author:  err
 * @Description:
 * @return:
 * @Date:  2024/6/11 13:46
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SongmenuList implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * id
     */
    @TableId(value = "songmenu_list_id", type = IdType.AUTO)
    private Integer songmenuListId;

    /**
     * 歌曲id
     */
    private Integer songId;

    /**
     * 歌单id
     */
    private Integer songmenuId;


}
