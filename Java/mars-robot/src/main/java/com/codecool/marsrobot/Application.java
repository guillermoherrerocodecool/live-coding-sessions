package com.codecool.marsrobot;

import com.codecool.marsrobot.data.Planet;
import com.codecool.marsrobot.data.Position;
import com.codecool.marsrobot.data.Robot;
import com.codecool.marsrobot.logic.ExplorationSimulator;
import com.codecool.marsrobot.logic.RobotEngine;
import com.codecool.marsrobot.logic.movement.Down;
import com.codecool.marsrobot.logic.movement.Movement;
import com.codecool.marsrobot.logic.movement.Right;
import com.codecool.marsrobot.logic.movement.Up;
import com.codecool.marsrobot.ui.Display;
import com.codecool.marsrobot.ui.XBoxController;

import java.util.Scanner;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        Position position = new Position(0, 0);
        Robot robot = new Robot(position);
        Planet planet = new Planet(5);
        Set<Movement> movements = Set.of(new Up(), new Down(), new Right());
        RobotEngine robotEngine = new RobotEngine(movements);
        Scanner scanner = new Scanner(System.in);
        XBoxController xBoxController = new XBoxController(movements, scanner);
        Display display = new Display();
        ExplorationSimulator simulator = new ExplorationSimulator(display, xBoxController, robotEngine);
        simulator.simulate(planet, robot);
    }
}
