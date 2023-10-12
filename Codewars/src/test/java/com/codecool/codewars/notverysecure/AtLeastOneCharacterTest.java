package com.codecool.codewars.notverysecure;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AtLeastOneCharacterTest {
    AtLeastOneCharacter check = new AtLeastOneCharacter();

    @ParameterizedTest
    @CsvSource({
            "false, ''",
            "true, ' '",
            "true, a",
            "true, 1",
    })
    void validate(boolean expected, String input) {
        boolean result = check.validate(input);

        assertEquals(expected, result);
    }
}