package com.qf.common.swagger.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("swagger")
@Data
public class SwaggerConfigProperties {
    private boolean enable=true;

    private String  basePackage;

    private String title;

    private  String description;

    private String version;

    private String name;

    private  String url;
    private  String  email;
}
