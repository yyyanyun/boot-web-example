package com.qf.common.update.config;


import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.qf.common.update.config.properties.AliYunOssProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class AliYunOssConfig {
    @Resource
    private AliYunOssProperties aliYunOssProperties;

    @Bean
    public OSS oss(){
        return new OSSClientBuilder().build(
                // url
                aliYunOssProperties.getEndpoint(),
                // id
                aliYunOssProperties.getAccessKeyId(),
                // key
                aliYunOssProperties.getAccessKeySecret()
        );
    }
}
