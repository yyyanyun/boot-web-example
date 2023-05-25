package com.qf.common.validation.config;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;


@Configuration
public class Validator {
    @Bean
    public javax.validation.Validator myValidator() {
        return Validation.byProvider(HibernateValidator.class).configure()
                .failFast(true)
                .buildValidatorFactory().getValidator();
    }
}
