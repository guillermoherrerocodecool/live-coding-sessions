package com.codecool.codewars.partyoutlier;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class OutlierFinder {
    public int find(int[] integers) {
        return Arrays.stream(integers)
                .boxed()
                .collect(groupingBy(n -> n % 2 == 0 ? "even" : "odd", toList()))
                .values().stream()
                .filter(numbers -> numbers.size() == 1)
                .flatMap(List::stream)
                .findFirst()
                .orElseThrow();
    }
}
