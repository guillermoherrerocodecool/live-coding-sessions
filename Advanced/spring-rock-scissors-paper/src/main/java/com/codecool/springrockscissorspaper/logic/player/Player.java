package com.codecool.springrockscissorspaper.logic.player;

import com.codecool.springrockscissorspaper.data.Move;

public interface Player {
    Move move();
    boolean wantsToPlayAgain();
}
