package com.codecool.springrockscissorspaper.configuration;

import com.codecool.springrockscissorspaper.logic.Game;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RunnerConfiguration {
    
    @Bean
    ApplicationRunner runner(Game game){
        return args -> game.run();
    }
}
