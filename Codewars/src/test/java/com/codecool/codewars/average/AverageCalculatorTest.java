package com.codecool.codewars.average;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AverageCalculatorTest {
    AverageCalculator calculator = new AverageCalculator();

    @Test
    void calculateWhenEmpty() {
        int[] numbers = new int[]{};

        double result = calculator.calculate(numbers);

        double expected = 0;
        assertEquals(expected, result);
    }

    @Test
    void calculateWhenOneNumber() {
        int[] numbers = new int[]{2};

        double result = calculator.calculate(numbers);

        double expected = 2;
        assertEquals(expected, result);
    }

    @Test
    void calculateWhenTwoNumbers() {
        int[] numbers = new int[]{1, 2};

        double result = calculator.calculate(numbers);

        double expected = 1.5;
        assertEquals(expected, result);
    }
}