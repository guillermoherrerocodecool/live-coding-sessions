package com.codecool.codewars.sortandstar;

import java.util.stream.Stream;

public class Sorter {
    public String[] sort(String[] strings) {
        return Stream.of(strings)
                .sorted()
                .toArray(String[]::new);
    }
}
