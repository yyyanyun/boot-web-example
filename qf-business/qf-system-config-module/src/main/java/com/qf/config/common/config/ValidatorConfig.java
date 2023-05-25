package com.qf.config.common.config;
import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;

//JSR330 参数校验
@Configuration
public class ValidatorConfig {
    /**
     * 修改校验模式
     *
     * @return
     */
    @Bean
    public Validator validator() {
        return Validation.byProvider(HibernateValidator.class).configure()
                .failFast(true)
                .buildValidatorFactory().getValidator();
    }
}
