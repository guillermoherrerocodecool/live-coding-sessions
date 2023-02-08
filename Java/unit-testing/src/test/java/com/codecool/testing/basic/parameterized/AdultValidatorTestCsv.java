package com.codecool.testing.basic.parameterized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdultValidatorTestCsv {
    AdultValidator validator = new AdultValidator();

    @ParameterizedTest
    @CsvSource({
            "false, -1",
            "false, 0",
            "false, 16",
            "false, 17",
            "true, 18",
            "true, 19",
    })
    void isAdult(boolean expected, int age) { // AAA
        boolean result = validator.isAdult(age);

        assertEquals(expected, result);
    }
    
    @ParameterizedTest
    @CsvFileSource(resources = "/is-adult-source.csv", numLinesToSkip = 1)
    void isAdultWithFileSource(boolean expected, int age) { // AAA
        boolean result = validator.isAdult(age);

        assertEquals(expected, result);
    }
}