package com.codecool.springrockscissorspaper.logic.player;

import com.codecool.springrockscissorspaper.data.Move;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

//@Service
public class Computer implements Player {
    private final Random random;
    private final List<Move> moves;

    public Computer(Random random, List<Move> moves) {
        this.random = random;
        this.moves = moves;
    }

    @Override
    public Move move() {
        int randomIndex = random.nextInt(moves.size());
        return moves.get(randomIndex);
    }

    @Override
    public boolean wantsToPlayAgain() {
        return true;
    }
}
