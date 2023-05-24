package com.qf.cabinet.config;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;


@Configuration
public class validator {

    @Bean


    public Validator myValidator() {
        return Validation.byProvider(HibernateValidator.class).configure()
                .failFast(true)
                .buildValidatorFactory().getValidator();
    }
}
