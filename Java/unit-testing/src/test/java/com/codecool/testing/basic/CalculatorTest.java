package com.codecool.testing.basic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    void addPlusOne() {
        int number1 = 0;
        int number2 = 1;

        int result = calculator.add(number1, number2);

        int expected = 1;
        assertEquals(expected, result);
    }

    @Test
    void addPlusMinusOne() {
        int number1 = 0;
        int number2 = -1;

        int result = calculator.add(number1, number2);

        int expected = -1;
        assertEquals(expected, result);
    }
}