package com.codecool.codewars.expandedform;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class NumberFormExpander {
    public String expand(int number) {
        Queue<String> digits = getDigits(number);
        return IntStream.generate(() -> 0)
                .limit(digits.size())
                .mapToObj(n -> digits.poll())
                .filter(digit -> !digit.equals("0"))
                .map(digit -> digit + "0".repeat(digits.size()))
                .collect(joining(" + "));
    }

    private Queue<String> getDigits(int number) {
        String digits = String.valueOf(number);
        return Stream.of(digits.split(""))
                .collect(toCollection(LinkedList::new));
    }
}
