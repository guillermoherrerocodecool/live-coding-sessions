package com.codecool.cats.configuration;

import com.codecool.cats.service.CatStorage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class BeansConfiguration {

    @Bean
    CatStorage catStorage() {
        return new CatStorage(new ArrayList<>());
    }
}
