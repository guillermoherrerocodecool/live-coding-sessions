package com.codecool.codewars.isogram;


import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class IsogramValidator {

    public boolean isIsogram(String text) {
        return Stream.of(text.split(""))
                .map(String::toLowerCase)
                .collect(groupingBy(Function.identity(), counting()))
                .values().stream()
                .allMatch(e -> e < 2);
    }
}
