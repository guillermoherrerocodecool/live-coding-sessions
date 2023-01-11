package com.codecool.springrockscissorspaper.configuration;

import com.codecool.springrockscissorspaper.data.Move;
import com.codecool.springrockscissorspaper.logic.player.Human;
import com.codecool.springrockscissorspaper.logic.player.Player;
import com.codecool.springrockscissorspaper.ui.Display;
import com.codecool.springrockscissorspaper.ui.Input;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PlayerConfiguration {
    @Bean
    Player player1(Display display, Input input, List<Move> moves) {
        return new Human(display, input, moves);
    }

    @Bean
    Player player2(Display display, Input input, List<Move> moves) {
        return new Human(display, input, moves);
    }
}
