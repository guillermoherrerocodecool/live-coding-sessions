package com.codecool.codewars.countingsheep;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SheepCounterTest {
    SheepCounter sheepCounter = new SheepCounter();

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(0, new Boolean[]{}),
                Arguments.of(0, new Boolean[]{null}),
                Arguments.of(0, new Boolean[]{false}),
                Arguments.of(1, new Boolean[]{true}),
                Arguments.of(2, new Boolean[]{true, false, true}),
                Arguments.of(17, new Boolean[]
                        {true,  true,  true,  false,
                        true,  true,  true,  true ,
                        true,  false, true,  false,
                        true,  false, false, true ,
                        true,  true,  true,  true ,
                        false, false, true,  true }));
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void count(int expected, Boolean[] sheep) {
        // AAA
        // Arrange
        // Act
        int result = sheepCounter.count(sheep);
        // Assertion
        Assertions.assertEquals(expected, result);
    }
}