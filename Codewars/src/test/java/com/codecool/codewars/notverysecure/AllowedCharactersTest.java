package com.codecool.codewars.notverysecure;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AllowedCharactersTest {
    String allowed = "abC";
    AllowedCharacters check = new AllowedCharacters(allowed);

    @ParameterizedTest
    @CsvSource({
            "false, c",
            "false, 1",
            "false, 1a",
            "true, a",
            "true, b",
            "true, ab",
            "true, C",
    })
    void validate(boolean expected, String input) {
        boolean result = check.validate(input);

        assertEquals(expected, result);
    }
}