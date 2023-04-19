package com.codecool.codewars.findunique;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.of;

class UniqueNumberFinderTest {
    UniqueNumberFinder finder = new UniqueNumberFinder();

    public static Stream<Arguments> parameters() {
        return Stream.of(
                of(1, new double[]{0, 0, 1}),
                of(1, new double[]{0, 1, 0}),
                of(1, new double[]{1, 0, 0}),
                of(1, new double[]{-1, -1, 1}),
                of(1, new double[]{-1, 1, -1}),
                of(1, new double[]{1, -1, -1}),
                of(2, new double[]{1, 1, 1, 2, 1, 1}),
                of(0.55, new double[]{0, 0, 0.55, 0, 0})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void find(double expected, double[] numbers) {
        double result = finder.find(numbers);

        assertEquals(expected, result);
    }

    @Test
    void findReceivesInputWithoutSingleUniqueNumber() {
        double[] numbers = {1, 1, 2, 2};

        assertThrows(NoSuchElementException.class, () -> finder.find(numbers));
    }
}