package com.codecool.codewars.meansquare;

import java.util.stream.IntStream;

public class MeanSquareCalculator {
    public double calculate(int[] numbers1, int[] numbers2) {
        return IntStream.range(0, numbers1.length)
                .map(index -> numbers1[index] - numbers2[index])
                .map(number -> number * number)
                .average()
                .orElse(0);
    }
}
