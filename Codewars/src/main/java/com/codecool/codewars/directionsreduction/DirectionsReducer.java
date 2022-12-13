package com.codecool.codewars.directionsreduction;

import java.util.stream.Stream;

public class DirectionsReducer {
    public String[] reduce(String[] directions) {
        String text = String.join(",", directions);
        boolean wasTextAltered = true;
        while (wasTextAltered) {
            int length = text.length();
            text = text.replaceAll("NORTH,SOUTH", "");
            text = text.replaceAll("SOUTH,NORTH", "");
            text = text.replaceAll("EAST,WEST", "");
            text = text.replaceAll("WEST,EAST", "");
            text = text.replaceAll("^,", "");
            text = text.replaceAll(",,", ",");
            wasTextAltered = length != text.length();
        }
        return Stream.of(text.split(","))
                .filter(direction -> !direction.isBlank())
                .toArray(String[]::new);
    }
}
