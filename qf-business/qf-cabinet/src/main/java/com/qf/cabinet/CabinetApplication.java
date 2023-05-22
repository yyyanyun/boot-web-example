package com.qf.cabinet;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.qf")
@MapperScan("com.qf.**.mapper")
public class CabinetApplication {
    public static void main(String[] args) {
        SpringApplication.run(CabinetApplication.class,args);
    }
}
