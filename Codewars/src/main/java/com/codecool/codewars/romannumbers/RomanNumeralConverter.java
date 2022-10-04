package com.codecool.codewars.romannumbers;

import java.util.List;

public class RomanNumeralConverter {
    private final List<Swap> swaps;

    public RomanNumeralConverter(List<Swap> swaps) {
        this.swaps = swaps;
    }

    public String convert(int number) {
        String solution = "I".repeat(number);
        for (Swap swap : swaps) {
            solution = solution.replace(swap.original(), swap.replacement());
        }
        return solution;
    }

    record Swap(String original, String replacement) {
    }
}
