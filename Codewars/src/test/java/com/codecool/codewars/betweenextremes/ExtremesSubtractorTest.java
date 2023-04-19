package com.codecool.codewars.betweenextremes;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

class ExtremesSubtractorTest {
    ExtremesSubtractor adder = new ExtremesSubtractor();

    public static Stream<Arguments> parameters() {
        return Stream.of(
                of(0, new int[]{0, 0}),
                of(1, new int[]{1, 0}),
                of(1, new int[]{0, 1}),
                of(0, new int[]{1, 1}),
                of(2, new int[]{-1, 1}),
                of(2, new int[]{1, -1}),
                of(1, new int[]{2, 1}),
                of(2, new int[]{-1, 0, 1}),
                of(1, new int[]{-1, 0, -1}),
                of(2, new int[]{1, -1, 0}),
                of(42, new int[]{21, 34, 54, 43, 26, 12}),
                of(99, new int[]{-1, -41, -77, -100})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void sumExtremes(int expected, int[] numbers) {
        int result = adder.subtractExtremes(numbers);

        assertEquals(expected, result);
    }
}