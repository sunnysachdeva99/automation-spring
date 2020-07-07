package com.practice.automationspring.config;

import com.github.javafaker.Faker;
import com.practice.automationspring.annotations.LazyConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;


@LazyConfiguration
public class FakerConfig {

    @Bean
    public Faker getFaker(){
        Faker faker = new Faker();
        return faker;
    }
}
