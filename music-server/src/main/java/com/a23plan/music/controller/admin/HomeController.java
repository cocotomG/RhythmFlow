package com.a23plan.music.controller.admin;

import com.a23plan.music.entity.Classify;
import com.a23plan.music.common.CommonResult;
import com.a23plan.music.service.AccountService;
import com.a23plan.music.service.SingerService;
import com.a23plan.music.service.SongService;
import com.a23plan.music.service.SongmenuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:  err
 * @Description:
 * @return:
 * @Date:  2024/6/11 13:44
 */
@RestController
@RequestMapping("/api")
public class HomeController {

    @Resource
    private AccountService accountService;
    @Resource
    private SingerService singerService;
    @Resource
    private SongmenuService songmenuService;
    @Resource
    private SongService songService;

    @GetMapping("/count")
    public CommonResult<Map<String,Object>> getCount(){
        Map<String,Object> map = new HashMap<>(16);
        //查询用户总数
        int userCount = accountService.count();
        //歌单总数
        int playListCount = songmenuService.count();
        //歌手总数
        int singerCount = singerService.count();
        //查询歌曲总数
        int songCount = songService.count();

        map.put("userCount",userCount);
        map.put("playListCount",playListCount);
        map.put("singerCount",singerCount);
        map.put("songCount",songCount);
        return CommonResult.success(map);
    }

    @GetMapping("/statistical")
    public CommonResult<Map<String,Object>> getStatistical(){
        Map<String,Object> map = new HashMap<>(16);
        //查询用户性别比列
        List<Map<String,Object>> accountList = accountService.getAccountBYSex();
        //查询歌手比列
        List<Map<String,Object>> singerList = singerService.getSingBySex();
        //查询歌单类型
        List<Classify> classifies = songmenuService.getClassifyCount();
        map.put("accountList",accountList);
        map.put("singerList",singerList);
        map.put("classifies",classifies);
        return CommonResult.success(map);
    }
}
