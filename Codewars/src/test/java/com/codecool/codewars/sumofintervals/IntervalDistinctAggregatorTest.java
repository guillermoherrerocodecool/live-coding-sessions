package com.codecool.codewars.sumofintervals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

class IntervalDistinctAggregatorTest {
    IntervalDistinctAggregator aggregator = new IntervalDistinctAggregator();

    public static Stream<Arguments> parameters() {
        return Stream.of(
                of(0, new int[][]{}),
                of(0, new int[][]{{0, 0}, {0, 0}}),
                of(1, new int[][]{{0, 1}, {0, 0}}),
                of(1, new int[][]{{0, 0}, {0, 1}}),
                of(1, new int[][]{{0, 1}, {0, 1}}),
                of(2, new int[][]{{0, 1}, {0, 2}}),
                of(2, new int[][]{{0, 1}, {-1, 1}}),
                of(3, new int[][]{{0, 1}, {2, 3}, {4, 5}}),

                of(0, new int[][]{{4, 4}, {6, 6}, {8, 8}}),
                of(9, new int[][]{{1, 2}, {6, 10}, {11, 15}}),
                of(19, new int[][]{{1, 5}, {10, 20}, {1, 6}, {16, 19}, {5, 11}}),
                
                of(2_000_000_000, new int[][]{{-1_000_000_000, 1_000_000_000}}),
                of(100_000_030, new int[][]{{0, 20}, {-100_000_000, 10}, {30, 40}})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void aggregate(int expected, int[][] intervals) {
        int result = aggregator.aggregate(intervals);

        assertEquals(expected, result);
    }
}