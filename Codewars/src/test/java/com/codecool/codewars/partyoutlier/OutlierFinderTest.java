package com.codecool.codewars.partyoutlier;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

class OutlierFinderTest {
    OutlierFinder finder = new OutlierFinder();

    public static Stream<Arguments> parameters() {
        return Stream.of(
                of(1, new int[]{0, 0, 1}),
                of(1, new int[]{0, 1, 0}),
                of(1, new int[]{1, 0, 0}),
                of(0, new int[]{1, 1, 0}),
                of(0, new int[]{1, 0, 1}),
                of(0, new int[]{0, 1, 1}),
                of(1, new int[]{0, 0, 0, 0, 0, 1}),
                of(11, new int[]{2, 4, 0, 100, 4, 11, 2602, 36}),
                of(160, new int[]{160, 3, 1719, 19, 11, 13, -21})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void find(int expected, int[] numbers) {
        int result = finder.find(numbers);

        assertEquals(expected, result);
    }
}