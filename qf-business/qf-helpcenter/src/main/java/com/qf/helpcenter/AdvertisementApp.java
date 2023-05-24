package com.qf.helpcenter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.qf.**.mapper")
@SpringBootApplication
public class AdvertisementApp {
    public static void main(String[] args) {
        SpringApplication.run(AdvertisementApp.class,args);
    }
}
