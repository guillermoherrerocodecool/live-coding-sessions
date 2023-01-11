package com.codecool.springrockscissorspaper.ui;

import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class Input {
    private final Scanner scanner;

    public Input(Scanner scanner) {
        this.scanner = scanner;
    }

    public String scan() {
        return scanner.nextLine();
    }
}
