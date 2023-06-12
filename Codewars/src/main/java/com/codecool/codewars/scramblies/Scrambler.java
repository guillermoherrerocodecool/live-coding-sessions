package com.codecool.codewars.scramblies;

import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Scrambler {
    public boolean scramble(String string1, String string2) {
        Map<Integer, Long> appearances = countAsciiAppearances(string1);
        return string2.chars()
                .allMatch(ascii -> couldPop(ascii, appearances));
    }

    private Map<Integer, Long> countAsciiAppearances(String string1) {
        return string1.chars()
                .boxed()
                .collect(groupingBy(identity(), counting()));
    }

    private boolean couldPop(int ascii, Map<Integer, Long> appearances) {
        return -1L != appearances.compute(ascii, (k, v) -> v == null ? -1L : v - 1);
    }
}
