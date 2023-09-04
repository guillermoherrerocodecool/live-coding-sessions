package com.codecool.codewars.ascenddescendrepeat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UpDownStringGeneratorTest {
    UpDownStringGenerator generator = new UpDownStringGenerator();

    @ParameterizedTest
    @CsvSource({
            "'', 0, 1, 2",
            "'', 1, 2, 1",
            "1, 1, 1, 1",
            "11, 2, 1, 1",
            "12, 2, 1, 2",
            "1212, 4, 1, 2",
            "1232123212, 10, 1, 3",
            "-, 1, -1, 1",
            "-1, 2, -1, 1",
            "-1010-1, 7, -1, 1",
            "-1010-, 6, -1, 1",

            "12321, 5, 1, 3",
            "01210121012101, 14, 0, 2",
            "56789876567, 11, 5, 9",
    })
    void generate(String expected, int length, int minimum, int maximum) {
        String result = generator.generate(length, minimum, maximum);

        assertEquals(expected, result);
    }
}