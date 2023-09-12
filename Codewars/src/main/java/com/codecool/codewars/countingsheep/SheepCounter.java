package com.codecool.codewars.countingsheep;

import java.util.Objects;
import java.util.stream.Stream;

public class SheepCounter {
    public int count(Boolean[] sheep) {
        return Stream.of(sheep)
                .filter(e -> Objects.equals(e, true))
                .mapToInt(e -> 1)
                .sum();
    }
}
