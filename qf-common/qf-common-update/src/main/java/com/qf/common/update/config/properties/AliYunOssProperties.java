package com.qf.common.update.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("aliyun.oss")
public class AliYunOssProperties {
    // 路径地址
    private String endpoint;
    // 访问权限id
    private String accessKeyId;
    // 访问权限key
    private String accessKeySecret;
    // Bucket名称
    private String bucketName;
}
