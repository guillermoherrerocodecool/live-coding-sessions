package com.codecool.marsrobot.logic.movement;

import com.codecool.marsrobot.data.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DownTest {
    Movement movement = new Down();

    @Test
    void getCommand() {
        String result = movement.getCommand();

        String expected = "DOWN";
        assertEquals(expected, result);
    }

    @Test
    void move() {
        Position position = new Position(0, 0);

        Position result = movement.move(position);

        Position expected = new Position(0, 1);
        assertEquals(expected, result);
    }
}