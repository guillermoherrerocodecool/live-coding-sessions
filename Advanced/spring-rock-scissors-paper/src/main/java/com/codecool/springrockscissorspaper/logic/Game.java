package com.codecool.springrockscissorspaper.logic;

import com.codecool.springrockscissorspaper.data.Move;
import com.codecool.springrockscissorspaper.logic.player.Player;
import com.codecool.springrockscissorspaper.ui.Display;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Game {
    private final List<Player> players;
    private final Judge judge;
    private final Display display;
    
    public Game(List<Player> players, Judge judge, Display display) {
        this.players = players;
        this.judge = judge;
        this.display = display;
    }

    public void run() {
        display.welcome();
        boolean playersWantToPlay = true;
        while(playersWantToPlay){
            playOneRound();
            playersWantToPlay = ask();
        }
        display.goodbye();
    }

    private void playOneRound() {
        List<Move> moves = players.stream()
                .map(Player::move)
                .toList();
        String result = judge.judge(moves);
        display.show(result);
    }

    private boolean ask() {
        return players.stream()
                .allMatch(Player::wantsToPlayAgain);
    }
}
