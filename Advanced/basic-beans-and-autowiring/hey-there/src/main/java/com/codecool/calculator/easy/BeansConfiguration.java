package com.codecool.calculator.easy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class BeansConfiguration {

    @Bean
    @Order(-2)
    Punctuation exclamationMark() {
        return new Punctuation("!");
    }

    @Bean
    @Order(1)
    Punctuation questionMark() {
        return new Punctuation("?");
    }
    @Order(0)
    @Bean
    Punctuation suspense() {
        return new Punctuation("...");
    }
}
