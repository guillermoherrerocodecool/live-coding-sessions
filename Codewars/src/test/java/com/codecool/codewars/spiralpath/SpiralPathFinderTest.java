package com.codecool.codewars.spiralpath;


import com.codecool.codewars.spiralpath.SpiralPathFinder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

class SpiralPathFinderTest {
    SpiralPathFinder spiralPathFinder = new SpiralPathFinder();

    public static Stream<Arguments> parameters() {
        return Stream.of(
                of(new int[]{}, new int[][]{}),
                of(new int[]{1}, new int[][]{{1}}),
                of(new int[]{1, 3, 4, 2}, new int[][]{{1, 2}, {3, 4}}),
                of(new int[]{1, 4, 7, 8, 9, 6, 3, 2, 5}, new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void find(int[] expected, int[][] chart) {
        int[] result = spiralPathFinder.find(chart);
        System.out.println("result = " + Arrays.toString(result));
        System.out.println("expected = " + Arrays.toString(expected));
        assertArrayEquals(expected, result);
    }
}