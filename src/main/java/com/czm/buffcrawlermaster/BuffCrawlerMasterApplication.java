package com.czm.buffcrawlermaster;

import cn.hutool.cron.CronUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.czm.buffcrawlermaster.dao")
public class BuffCrawlerMasterApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuffCrawlerMasterApplication.class, args);
        CronUtil.start();
    }

}
