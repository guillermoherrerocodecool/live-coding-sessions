package com.codecool.springrockscissorspaper.ui;

import com.codecool.springrockscissorspaper.data.Move;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class Display {
    private final List<Move> moves;

    public Display(List<Move> moves) {
        this.moves = moves;
    }

    public void welcome() {
        String message = "Welcome to the " + getMoveNames() + " game!";
        System.out.println(message);
    }

    private String getMoveNames() {
        return moves.stream()
                .map(Move::name)
                .map(this::capitalize)
                .collect(Collectors.joining(", "));
    }

    private String capitalize(String name) {
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }

    public void goodbye() {
        System.out.println("Goodbye");
    }

    public void choose() {
        System.out.print("Choose a move (" + getMoveNames() + "): ");
    }

    public void show(String result) {
        System.out.println(result);
    }

    public void playAgain() {
        System.out.print("Do you want to play again? (y, n): ");
    }
}
