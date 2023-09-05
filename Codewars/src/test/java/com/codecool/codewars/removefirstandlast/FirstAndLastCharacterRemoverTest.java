package com.codecool.codewars.removefirstandlast;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class FirstAndLastCharacterRemoverTest {
    FirstAndLastCharacterRemover remover = new FirstAndLastCharacterRemover();

    @ParameterizedTest
    @CsvSource({
            "'', ab",
            "b, abc",
            "B, ABC",
            "B, aBc",
            "bc, abcd",
            "BC, aBCd",
            "Bc, aBcd",
            "bC, abCd"
    })
    void remove(String expected, String text) {
        String result = remover.remove(text);

        Assertions.assertEquals(expected, result);
    }
}