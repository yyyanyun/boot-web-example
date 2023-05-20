package com.qf.member;



import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
@MapperScan("com.qf.**.mapper")
public class MemberApp {
    public static void main(String[] args) {
        SpringApplication.run(MemberApp.class,args);
    }
}
