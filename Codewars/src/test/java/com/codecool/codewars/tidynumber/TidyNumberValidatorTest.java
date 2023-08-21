package com.codecool.codewars.tidynumber;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TidyNumberValidatorTest {
    TidyNumberValidator validator = new TidyNumberValidator();

    @ParameterizedTest
    @CsvSource({
            "true, 0",
            "true, 1",
            "true, 9",
            "false, 10",
            "true, 11",
            "true, 12",
            "false, 21",
            "true, 22",
            "true, 23",

            "true, 12",
            "false, 32",
            "true, 39",
            "false, 1024",
            "false, 12576",
            "true,  13579",
            "true,  2335",
    })
    void isTidyNumber(boolean expected, int number) {
        boolean result = validator.isTidyNumber(number);

        assertEquals(expected, result);
    }
}