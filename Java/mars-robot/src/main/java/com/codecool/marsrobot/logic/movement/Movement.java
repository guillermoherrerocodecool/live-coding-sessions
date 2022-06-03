package com.codecool.marsrobot.logic.movement;

import com.codecool.marsrobot.data.Position;

public interface Movement {
    String getCommand();
    Position move(Position position);
}
