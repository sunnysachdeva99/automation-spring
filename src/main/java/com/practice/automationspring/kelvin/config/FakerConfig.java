package com.practice.automationspring.kelvin.config;

import com.github.javafaker.Faker;
import com.practice.automationspring.kelvin.annotations.LazyConfiguration;
import org.springframework.context.annotation.Bean;


@LazyConfiguration
public class FakerConfig {

    @Bean
    public Faker getFaker(){
        Faker faker = new Faker();
        return faker;
    }
}
