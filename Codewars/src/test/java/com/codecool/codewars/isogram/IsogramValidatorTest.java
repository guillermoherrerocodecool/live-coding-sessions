package com.codecool.codewars.isogram;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IsogramValidatorTest {
    IsogramValidator validator = new IsogramValidator();

    @ParameterizedTest
    @CsvSource({
            "true, ''",
            "true, a",
            "true, A",
            "true, ab",
            "true, Ab",
            "true, aB",
            "false, aa",
            "false, Aa",
            "false, aA",
            "false, aba",
            "false, aab",
            "false, baa",
            "true, Dermatoglyphics",
            "true, isogram",
            "false, moose",
            "false, isIsogram",
            "false, aba",
            "false, moOse",
            "true, thumbscrewjapingly",
    })
    void isIsogram(boolean expected, String text) {
        boolean result = validator.isIsogram(text);

        assertEquals(expected, result);
    }

}