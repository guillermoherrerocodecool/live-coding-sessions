package com.codecool.marsrobot.logic.movement;

import com.codecool.marsrobot.data.Position;

public class Right implements Movement {
    @Override
    public String getCommand() {
        return "RIGHT";
    }

    @Override
    public Position move(Position position) {
        return new Position(
                position.x() + 1,
                position.y()
        );
    }
}
