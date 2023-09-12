package com.codecool.codewars.sortandstar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StarTest {
    Star star = new Star();

    @ParameterizedTest
    @CsvSource({
            "'', ''",
            "a, a",
            "a***b, ab",
            "a***b***c, abc",
            "a***b***c*** ***a***b, abc ab",
    })
    void star(String expected, String string) {
        String result = star.star(string);

        Assertions.assertEquals(expected, result);
    }
}