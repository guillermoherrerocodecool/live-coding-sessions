package com.codecool.springrockscissorspaper.logic.player;

import com.codecool.springrockscissorspaper.data.Move;
import com.codecool.springrockscissorspaper.ui.Display;
import com.codecool.springrockscissorspaper.ui.Input;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service
public class Human implements Player {
    private final Display display;
    private final Input input;
    private final List<Move> moves;

    public Human(Display display, Input input, List<Move> moves) {
        this.display = display;
        this.input = input;
        this.moves = moves;
    }

    @Override
    public Move move() {
        Optional<Move> move = Optional.empty();
        while (move.isEmpty()) {
            move = ask();
        }
        return move.get();
    }

    private Optional<Move> ask() {
        display.choose();
        String option = input.scan();
        return moves.stream()
                .filter(move -> move.name().equalsIgnoreCase(option))
                .findFirst();
    }

    @Override
    public boolean wantsToPlayAgain() {
        display.playAgain();
        String answer = input.scan();
        return "y".equalsIgnoreCase(answer);
    }
}
