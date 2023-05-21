package com.qf.advertisement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.qf.**.mapper")
public class AdvertisementApp {
    public static void main(String[] args) {
        SpringApplication.run(AdvertisementApp.class,args);
    }
}
