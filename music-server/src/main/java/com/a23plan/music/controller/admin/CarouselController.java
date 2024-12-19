package com.a23plan.music.controller.admin;

import com.a23plan.music.entity.Carousel;
import com.a23plan.music.service.CarouselService;
import com.a23plan.music.common.CommonResult;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author:  err
 * @Description:
 * @return:
 * @Date:  2024/6/11 13:44
 */
@RequestMapping("/api")
@RestController
public class CarouselController {
    @Resource
    private CarouselService carouselService;

    /**
     * 获取所有轮播图
     * @return CommonResult<List<Carousel>>
     */
    @GetMapping("/carousel/list")
    public CommonResult<List<Carousel>> getCarouselList(){
        return CommonResult.success(carouselService.list());
    }

    /**
     * 添加轮播图
     * @param carousel
     * @return
     */
    @CacheEvict(value = "carousel")
    @PostMapping("/carousel/add")
    public CommonResult<String> addCarousel(@RequestBody Carousel carousel){
        int count = carouselService.count();
        //轮播图数据小于5，则可添加
        if(count < 5){
            boolean result = carouselService.save(carousel);
            return result ? CommonResult.success("添加轮播图成功") : CommonResult.faild("添加轮播图失败");
        }
        return CommonResult.faild("轮播图数据超过限制，不能添加");
    }

    /**
     * 修改轮播图
     * @param carousel
     * @return
     */
    @CacheEvict(value = "carousel")
    @PostMapping("/carousel/update")
    public CommonResult<String> updateCarousel(@RequestBody Carousel carousel){
        boolean result = carouselService.updateById(carousel);
        return result ? CommonResult.success("修改轮播图成功") : CommonResult.faild("修改轮播图失败");
    }

    /**
     * 删除轮播图
     * @param carouselId
     * @return
     */
    @CacheEvict(value = "carousel")
    @PostMapping("/carousel/delete/{carouselId}")
    public CommonResult<String> delCarousel(@NotNull(message = "id不能为空") @PathVariable("carouselId")Integer carouselId){
        boolean result = carouselService.removeById(carouselId);
        return result ? CommonResult.success("删除轮播图成功") : CommonResult.faild("删除轮播图失败");
    }
}
