package com.codecool.marsrobot.logic;

import com.codecool.marsrobot.data.Position;
import com.codecool.marsrobot.data.Robot;
import com.codecool.marsrobot.logic.movement.Movement;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class RobotEngineTest {
    Movement movement = mock(Movement.class);

    @Test
    void moveFindsMovement() {
        RobotEngine robotEngine = new RobotEngine(Set.of(movement));
        Position position = new Position(0, 0);
        Robot robot = new Robot(position);
        String command = "test";
        when(movement.getCommand()).thenReturn(command);
        when(movement.move(any(Position.class))).thenReturn(position);

        robotEngine.move(robot, command);

        verify(movement).getCommand();
        verify(movement).move(any(Position.class));
    }

    @Test
    void moveDoesNotFindMovement() {
        RobotEngine robotEngine = new RobotEngine(Set.of());
        Position position = new Position(0, 0);
        Robot robot = new Robot(position);
        String command = "test";

        assertThrows(IllegalArgumentException.class, () -> robotEngine.move(robot, command));
    }
}