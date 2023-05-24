package com.qf.mapper;



import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@MapperScan("com.qf.**.mapper")
public class MemberApp {
    public static void main(String[] args) {
        SpringApplication.run(MemberApp.class,args);
    }
}
