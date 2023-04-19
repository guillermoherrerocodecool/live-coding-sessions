package com.codecool.codewars.findunique;

import java.util.Arrays;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class UniqueStringFinder {
    public String find(String[] strings) {
        return Arrays.stream(strings)
                .map(SpacesInsensitiveString::new)
                .collect(groupingBy(identity(), counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(e -> e.getKey().value())
                .findFirst()
                .orElseThrow();
    }
}
