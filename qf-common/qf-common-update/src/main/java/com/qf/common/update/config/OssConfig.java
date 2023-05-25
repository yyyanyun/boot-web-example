package com.qf.common.update.config;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class OssConfig {

    @Resource
    OssConfigProperties ossConfigProperties;

    @Bean
    public OSS oss() {
        return  new OSSClientBuilder().build(ossConfigProperties.getEndpoint(), ossConfigProperties.getAccessKeyId(), ossConfigProperties.getAccessKeySecret());
    }
}
