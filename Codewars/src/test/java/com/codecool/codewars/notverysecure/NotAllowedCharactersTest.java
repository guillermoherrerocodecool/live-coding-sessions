package com.codecool.codewars.notverysecure;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NotAllowedCharactersTest {
    String rejected = "abC";
    NotAllowedCharacters check = new NotAllowedCharacters(rejected);

    @ParameterizedTest
    @CsvSource({
            "true, ''",
            "false, a",
            "false, b",
            "true, c",
            "false, C",
            "false, ca",
    })
    void validate(boolean expected, String input) {
        boolean result = check.validate(input);

        assertEquals(expected, result);
    }
}