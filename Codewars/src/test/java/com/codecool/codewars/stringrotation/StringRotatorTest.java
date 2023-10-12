package com.codecool.codewars.stringrotation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringRotatorTest {
    StringRotator rotator = new StringRotator();

    @ParameterizedTest
    @CsvSource({
            "-1, '', ''",
            "0, a, a",
            "0, ab, ab",
            "1, ab, ba",
            "1, abc, cab",
            "3, abcd, bcda",
            "-1, dog, god",
            "-1, hoop, pooh",
            "2, coffee, eecoff",
            "4, eecoff, coffee",
    })
    void rotate(int expected, String first, String second) {
        int result = rotator.rotate(first, second);

        assertEquals(expected, result);
    }
}