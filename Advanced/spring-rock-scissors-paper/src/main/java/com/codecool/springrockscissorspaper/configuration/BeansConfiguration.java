package com.codecool.springrockscissorspaper.configuration;

import com.codecool.springrockscissorspaper.data.Move;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;
import java.util.Scanner;

@Configuration
public class BeansConfiguration {

    @Bean
    Random random() {
        return new Random();
    }

    @Bean
    Scanner scanner() {
        return new Scanner(System.in);
    }
}
