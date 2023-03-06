package com.codecool.codewars.descendingorder;

import java.util.stream.Stream;

import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.joining;

public class DigitsSorter {
    public int sortDesc(int number) {
        return Stream.of(number)
                .map(String::valueOf)
                .map(digits -> digits.split(""))
                .flatMap(Stream::of)
                .sorted(reverseOrder())
                .collect(collectingAndThen(joining(), Integer::parseInt));
    }
}
