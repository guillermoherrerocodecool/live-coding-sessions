package com.codecool.codewars.validparentheses;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toCollection;

public class ParenthesesValidator {
    private final Map<String, Integer> values;

    public ParenthesesValidator(Map<String, Integer> values) {
        this.values = values;
    }

    public boolean validate(String parentheses) {
        Queue<Integer> numbers = toNumbers(parentheses);
        int counter = aggregate(numbers);
        return counter == 0;
    }

    private Queue<Integer> toNumbers(String parentheses) {
        return Stream.of(parentheses.split(""))
                .map(symbol -> values.getOrDefault(symbol, 0))
                .collect(toCollection(LinkedList::new));
    }

    private int aggregate(Queue<Integer> numbers) {
        int counter = 0;
        while (!numbers.isEmpty()) {
            int number = numbers.poll();
            counter += number;
            if (counter < 0) {
                return -1;
            }

        }
        return counter;
    }
}
