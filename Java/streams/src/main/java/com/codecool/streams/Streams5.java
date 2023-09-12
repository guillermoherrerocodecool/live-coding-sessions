package com.codecool.streams;

import java.util.List;
import java.util.stream.Collectors;

public class Streams5 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 2, 3);
        List<Integer> distinct = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("distinct = " + distinct);
    }
}
