package com.codecool.codewars.sumstringsasnumbers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumbersAsStringCalculatorTest {
    NumbersAsStringCalculator calculator = new NumbersAsStringCalculator();

    @ParameterizedTest
    @CsvSource({
            "'', '', ''",
            "0, 0, 0",
            "1, 1, 0",
            "1, 0, 1",
            "2, 1, 1",
            "9, 8, 1",
            "10, 9, 1",
            "11, 10, 1",
            "101, 100, 1",
            "108, 99, 9",
            "118, 99, 19",
            "579, 123, 456",
            "2, 001, 001",
            "1000000000000000000000000000000, 999999999999999999999999999999, 1",
    })
    void sum(String expected, String number1, String number2) {
        String result = calculator.sum(number1, number2);

        assertEquals(expected, result);
    }
}