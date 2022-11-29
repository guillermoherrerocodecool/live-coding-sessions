package com.codecool.codewars.nextbiggernumber;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

class NextBiggerNumberFinderTest {
    NextBiggerNumberFinder finder = new NextBiggerNumberFinder();

    public static Stream<Arguments> parameters() {
        return Stream.of(
                of(-1, 0),
                of(-1, 10),
                of(21, 12),
                of(132, 123),
                of(120, 102),
                of(201, 120),
                of(210, 201),
                of(-1, 210),
                of(531, 513),
                of(441, 414),
                of(414, 144),
                of(2071, 2017),
                of(19009, 10990)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void find(long expected, long number) {
        long result = finder.find(number);

        assertEquals(expected, result);
    }
}