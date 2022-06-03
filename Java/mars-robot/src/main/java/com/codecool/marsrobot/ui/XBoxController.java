package com.codecool.marsrobot.ui;

import com.codecool.marsrobot.logic.movement.Movement;

import java.util.Scanner;
import java.util.Set;

import static java.lang.String.*;
import static java.util.stream.Collectors.joining;

public class XBoxController {
    private final Set<Movement> movements;
    private final Scanner scanner;

    public XBoxController(Set<Movement> movements, Scanner scanner) {
        this.movements = movements;
        this.scanner = scanner;
    }

    public String getCommand() {
        System.out.print(format("Command (%s): ", getAvailableMovements()));
        return scanner.nextLine();
    }

    private String getAvailableMovements() {
        return movements.stream()
                .map(Movement::getCommand)
                .collect(joining(", "));
    }
}
