package com.codecool.marsrobot.ui;

import com.codecool.marsrobot.data.Planet;
import com.codecool.marsrobot.data.Position;
import com.codecool.marsrobot.data.Robot;

import java.util.stream.IntStream;

import static java.util.Arrays.fill;
import static java.util.stream.Collectors.joining;

public class Display {

    private static final String ROBOT_DISPLAY_SYMBOL = "0";

    public void display(Planet planet, Robot robot) {
        int size = planet.size();
        String[][] map = new String[size][size];
        render(planet, map);
        render(robot, map);
        display(planet, map);
    }

    private void render(Planet planet, String[][] map) {
        int size = planet.size();
        IntStream.range(0, size)
                .forEach(number -> fill(map[number], " "));
    }

    private void render(Robot robot, String[][] map) {
        Position position = robot.getPosition();
        int x = position.x();
        int y = position.y();
        map[x][y] = ROBOT_DISPLAY_SYMBOL;
    }

    private void display(Planet planet, String[][] map) {
        int size = planet.size();
        String separator = IntStream.range(0, size).mapToObj(n -> "==").collect(joining());
        System.out.println(separator);
        IntStream.range(0, size)
                .peek(y -> IntStream.range(0, size)
                        .forEach(x -> System.out.print(map[x][y] + " ")))
                .forEach(y -> System.out.println());
        System.out.println(separator);
    }
}
