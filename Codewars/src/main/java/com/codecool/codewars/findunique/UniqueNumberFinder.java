package com.codecool.codewars.findunique;

import java.util.Map;
import java.util.stream.DoubleStream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class UniqueNumberFinder {
    public double find(double[] numbers) {
        return DoubleStream.of(numbers)
                .boxed()
                .collect(groupingBy(identity(), counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow();
    }
}
