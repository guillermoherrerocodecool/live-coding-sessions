package com.codecool.springrockscissorspaper.logic;

import com.codecool.springrockscissorspaper.data.Move;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Judge {
    public String judge(List<Move> moves) {
        Move move1 = moves.get(0);
        Move move2 = moves.get(1);
        return move1.beats().contains(move2.name()) ? "Player 1 wins" :
                move2.beats().contains(move1.name()) ? "Player 2 wins" :
                        "It's a tie!";
    }
}
