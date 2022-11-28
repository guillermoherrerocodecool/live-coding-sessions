package com.codecool.codewars.sorttheodd;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toCollection;

public class OddNumberSorter {

    public int[] sort(int[] numbers) {
        Queue<Integer> oddNumbers = IntStream.of(numbers)
                .filter(this::isOdd)
                .sorted()
                .boxed()
                .collect(toCollection(LinkedList::new));
        return IntStream.of(numbers)
                .map(number -> isOdd(number) ? oddNumbers.poll() : number)
                .toArray();
    }

    private boolean isOdd(int number) {
        return number % 2 == 1;
    }
}
