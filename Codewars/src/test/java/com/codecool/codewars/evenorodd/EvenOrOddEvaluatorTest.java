package com.codecool.codewars.evenorodd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class EvenOrOddEvaluatorTest {
    EvenOrOddEvaluator evaluator = new EvenOrOddEvaluator();

    @ParameterizedTest
    @CsvSource({
            "Even, 0",
            "Odd, 1",
            "Odd, -1",
            "Even, 2",
            "Even, -2",
            "Odd, 11",
            "Odd, -11",
            "Even, 22",
            "Even, -22",
    })
    void evaluate(String expected, int number) {
        String result = evaluator.evaluate(number);

        Assertions.assertEquals(expected, result);
    }
}