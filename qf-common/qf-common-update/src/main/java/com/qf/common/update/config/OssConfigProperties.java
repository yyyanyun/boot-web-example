package com.qf.common.update.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties("oss")
public class OssConfigProperties {
    String endpoint = "https://oss-cn-hangzhou.aliyuncs.com";
    // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
    String accessKeyId = "LTAI5t8WhWtAx9VHCJ6sT6eb";
    String accessKeySecret = "tYF9eJf1wFqJacAuXfu4j5KN0jxSc1";
    // 填写Bucket名称，例如examplebucket。
    String bucketName = "com-qf-oss";
}
