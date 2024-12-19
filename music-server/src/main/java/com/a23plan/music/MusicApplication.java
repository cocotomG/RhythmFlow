package com.a23plan.music;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;



/**
 * @Author:  err
 * @Description: 启动类
 * @return:
 * @Date:  2024/6/11 13:49
 */
@SpringBootApplication
@MapperScan("com.a23plan.music.mapper")
@EnableCaching
public class MusicApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusicApplication.class, args);
    }

}
