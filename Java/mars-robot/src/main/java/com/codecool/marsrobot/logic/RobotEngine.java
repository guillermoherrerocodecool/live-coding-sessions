package com.codecool.marsrobot.logic;

import com.codecool.marsrobot.data.Position;
import com.codecool.marsrobot.data.Robot;
import com.codecool.marsrobot.logic.movement.Movement;

import java.util.Set;

public class RobotEngine {
    private final Set<Movement> movements;

    public RobotEngine(Set<Movement> movements) {
        this.movements = movements;
    }

    public void move(Robot robot, String command) {
        Position current = robot.getPosition();
        Position next = movements.stream()
                .filter(movement -> movement.getCommand().equals(command))
                .map(movement -> movement.move(current))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Command not supported: " + command));
        robot.setPosition(next);
    }
}
