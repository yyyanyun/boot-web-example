package com.qf.advertisement.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;


@Data
@Component("OssConfigProperties")
@ConfigurationProperties("oss")
public class OssConfigProperties {
    String endpoint ;
    // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
    String accessKeyId ;
    String accessKeySecret ;
    // 填写Bucket名称，例如examplebucket。
    String bucketName;
}
