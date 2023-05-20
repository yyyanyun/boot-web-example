package com.qf.common.swagger.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import javax.annotation.Resource;

@Configuration
@EnableOpenApi
public class SwaggerConfig {

    @Resource
    private SwaggerConfigProperties swaggerConfigProperties;

    @Bean
    public Docket  docket(ApiInfo apiInfo){
        return new Docket(DocumentationType.OAS_30)
                //生成文档 作者信息
                .apiInfo(apiInfo)
                //是否开启 swagger
                .enable(swaggerConfigProperties.isEnable())
                //生成api文档的路径
                .select()
                // 指定生成API文档的控制层
                .apis(RequestHandlerSelectors.basePackage(swaggerConfigProperties.getBasePackage()))
                // 任何路径都生成文档;
                .paths(PathSelectors.any())
                .build();
    }


    @Bean
    public ApiInfo  apiInfo(){
        return  new ApiInfoBuilder()
                .title(swaggerConfigProperties.getTitle())
                .description(swaggerConfigProperties.getDescription())
                .version(swaggerConfigProperties.getVersion())
                //作者信息
                .contact(new Contact(swaggerConfigProperties.getName(),swaggerConfigProperties.getUrl(),swaggerConfigProperties.getEmail()))
                .build();    }

}
