package com.qf.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.qf.**.mapper")
@SpringBootApplication
public class PackageApp {
    public static void main(String[] args) {
        SpringApplication.run(PackageApp.class,args);
    }
}
