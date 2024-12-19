package com.a23plan.music.controller.client;

import com.a23plan.music.Vo.PageParams;
import com.a23plan.music.common.CommonResult;
import com.a23plan.music.entity.Singer;
import com.a23plan.music.entity.Song;
import com.a23plan.music.entity.Songmenu;
import com.a23plan.music.service.SingerService;
import com.a23plan.music.service.SongService;
import com.a23plan.music.service.SongmenuListService;
import com.a23plan.music.service.SongmenuService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author:  err
 * @Description:
 * @return:
 * @Date:  2024/6/11 13:44
 */
@Validated
@RestController
@RequestMapping("/client")
public class DetailController {
    @Resource
    private SongmenuService songmenuService;
    @Resource
    private SingerService singerService;
    @Resource
    private SongmenuListService songmenuListService;
    @Resource
    private SongService songService;

    /**
     * 查询歌手详情
     * @param singerId
     * @return
     */
    @GetMapping("/singer/detail/{singerId}")
    public CommonResult<Singer> getSingerDetail(@NotNull(message = "歌手id不能为空") @PathVariable("singerId") Integer singerId){
        return CommonResult.success(singerService.getSingerDetail(singerId));
    }

    /**
     * 查询歌单详情
     * @param songmenuId
     * @return
     */
    @GetMapping("/playlist/detail/{songmenuId}")
    public CommonResult<Songmenu> getSongMenuDetail(@NotNull(message = "歌单id不能为空") @PathVariable("songmenuId") Integer songmenuId){
        Songmenu songmenu = songmenuService.getById(songmenuId);
        return CommonResult.success(songmenu);
    }

    @GetMapping("/song/list")
    public CommonResult<IPage<Song>> getSong(PageParams params){
        IPage<Song> iPage = new Page<>(params.getCurrentPage(),10);
        IPage<Song> page = null;
        if(params.getType() == 0){
            page = songService.page(iPage,new QueryWrapper<Song>().eq("singer_id",params.getSingerId()));
        }else{
            //根据歌单id查询歌曲
            List<Integer> list = songmenuListService.getSongMenu(params.getSongmenuId());
            if(list.size() == 0){
                return CommonResult.faild("没有数据");
            }
            page = songService.page(iPage,new QueryWrapper<Song>().in("song_id",list));
        }
        if(page.getTotal() == 0){
            return CommonResult.faild("没有数据");
        }
        return CommonResult.success(page);
    }
}
