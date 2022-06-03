package com.codecool.marsrobot.logic;

import com.codecool.marsrobot.data.Planet;
import com.codecool.marsrobot.data.Robot;
import com.codecool.marsrobot.ui.Display;
import com.codecool.marsrobot.ui.XBoxController;

public class ExplorationSimulator {
    private final Display display;
    private final XBoxController xBoxController;
    private final RobotEngine robotEngine;

    public ExplorationSimulator(Display display, XBoxController xBoxController, RobotEngine robotEngine) {
        this.display = display;
        this.xBoxController = xBoxController;
        this.robotEngine = robotEngine;
    }

    public void simulate(Planet planet, Robot robot) {
        while (true){
            display.display(planet, robot);
            String command = xBoxController.getCommand();
            if(command.isBlank()){
                return;
            }
            robotEngine.move(robot, command);
        }
    }

}
