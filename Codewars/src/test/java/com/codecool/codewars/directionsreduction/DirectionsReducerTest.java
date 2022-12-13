package com.codecool.codewars.directionsreduction;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

class DirectionsReducerTest {
    DirectionsReducer reducer = new DirectionsReducer();

    public static Stream<Arguments> parameters() {
        return Stream.of(
                of(new String[]{}, new String[]{}),
                of(new String[]{"NORTH"}, new String[]{"NORTH"}),
                of(new String[]{"NORTH", "NORTH"}, new String[]{"NORTH", "NORTH"}),
                of(new String[]{"NORTH", "EAST"}, new String[]{"NORTH", "EAST"}),
                of(new String[]{"NORTH", "EAST", "SOUTH"}, new String[]{"NORTH", "EAST", "SOUTH"}),
                of(new String[]{"NORTH", "EAST", "SOUTH", "WEST"}, new String[]{"NORTH", "EAST", "SOUTH", "WEST"}),
                of(new String[]{}, new String[]{"NORTH", "SOUTH"}),
                of(new String[]{}, new String[]{"SOUTH", "NORTH"}),
                of(new String[]{}, new String[]{"EAST", "WEST"}),
                of(new String[]{}, new String[]{"WEST", "EAST"}),
                of(new String[]{"WEST"}, new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void reduce(String[] expected, String[] directions) {
        String[] result = reducer.reduce(directions);

        assertArrayEquals(expected, result);
    }
}