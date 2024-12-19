package com.a23plan.music.controller.client;

import com.a23plan.music.Vo.PageParams;
import com.a23plan.music.common.CommonResult;
import com.a23plan.music.entity.Song;
import com.a23plan.music.entity.Songmenu;
import com.a23plan.music.service.SongService;
import com.a23plan.music.service.SongmenuService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @Author:  err
 * @Description:
 * @return:
 * @Date:  2024/6/11 13:45
 */
@RestController
@RequestMapping("/client")
public class SearchController {
    @Resource
    private SongService songService;
    @Resource
    private SongmenuService songmenuService;

    @GetMapping("/search/song")
    public CommonResult<IPage<Song>> searchSong(@Valid PageParams params){
        Page<Song> page = new Page<>(params.getCurrentPage(),10);
        IPage<Song> iPage = songService.page(page,new QueryWrapper<Song>().likeRight("name",params.getKeyword()));
        if(iPage.getTotal() == 0) {
            return CommonResult.faild("搜索不到相关数据");
        }
        return CommonResult.success(iPage);
    }

    @GetMapping("/search/playlist")
    public CommonResult<IPage<Songmenu>> searchSongMenu(@Valid PageParams params){
        Page<Songmenu> page = new Page<>(params.getCurrentPage(),10);
        IPage<Songmenu> iPage = songmenuService.page(page,new QueryWrapper<Songmenu>().likeRight("title",params.getKeyword()));
        if(iPage.getTotal() == 0) {
            return CommonResult.faild("搜索不到相关数据");
        }
        return CommonResult.success(iPage);
    }
}
