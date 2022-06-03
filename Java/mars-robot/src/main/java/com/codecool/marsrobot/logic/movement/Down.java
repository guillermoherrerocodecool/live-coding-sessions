package com.codecool.marsrobot.logic.movement;

import com.codecool.marsrobot.data.Position;

public class Down implements Movement {
    @Override
    public String getCommand() {
        return "DOWN";
    }

    @Override
    public Position move(Position position) {
        return new Position(
                position.x(),
                position.y() + 1
        );
    }
}
