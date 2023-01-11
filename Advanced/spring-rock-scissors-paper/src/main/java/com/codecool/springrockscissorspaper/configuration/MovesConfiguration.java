package com.codecool.springrockscissorspaper.configuration;

import com.codecool.springrockscissorspaper.data.Move;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties("game")
public class MovesConfiguration {

    private List<Move> moves;

    @Bean
    List<Move> moves() {
        return moves;
    }
    
    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }
}
