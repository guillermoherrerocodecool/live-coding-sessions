package com.codecool.marsrobot.logic.movement;

import com.codecool.marsrobot.data.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RightTest {
    Movement movement = new Right();

    @Test
    void getCommand() {
        String result = movement.getCommand();

        String expected = "RIGHT";
        assertEquals(expected, result);
    }

    @Test
    void move() {
        Position position = new Position(0, 0);

        Position result = movement.move(position);

        Position expected = new Position(1, 0);
        assertEquals(expected, result);
    }
}