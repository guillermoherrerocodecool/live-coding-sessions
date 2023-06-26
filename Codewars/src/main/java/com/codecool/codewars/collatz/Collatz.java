package com.codecool.codewars.collatz;

public class Collatz {
    private final String delimiter;

    public Collatz(String delimiter) {
        this.delimiter = delimiter;
    }

    public String collatz(int number) {
        return number == 1 ? "1" : number + delimiter + collatz(next(number));
    }

    private int next(int number) {
        return isEven(number) ? number / 2 : 3 * number + 1;
    }

    private boolean isEven(int number) {
        return number % 2 == 0;
    }
}
