package com.codecool.codewars.meansquare;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

class MeanSquareCalculatorTest {
    MeanSquareCalculator calculator = new MeanSquareCalculator();

    public static Stream<Arguments> parameters() {
        return Stream.of(
                of(0, new int[]{}, new int[]{}),
                of(0, new int[]{0}, new int[]{0}),
                of(1, new int[]{1}, new int[]{0}),
                of(1, new int[]{-1}, new int[]{0}),
                of(1, new int[]{0}, new int[]{1}),
                of(1, new int[]{0}, new int[]{-1}),
                of(16.5, new int[]{10, 20, 10, 2}, new int[]{10, 25, 5, -2}),
                of(1, new int[]{-1, 0}, new int[]{0, -1})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void calculate(double expected, int[] numbers1, int[] numbers2) {
        double result = calculator.calculate(numbers1, numbers2);

        assertEquals(expected, result);
    }
}