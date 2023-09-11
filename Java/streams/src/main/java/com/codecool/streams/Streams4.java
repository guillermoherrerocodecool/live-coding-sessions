package com.codecool.streams;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class Streams4 {
    public static void main(String[] args) {
        List<String> names = List.of("Vahe", "Tobias", "Mona", "David", "Gabriel", "Dora", "Dean");
        Optional<List<String>> biggestTeam = names.stream()
                .collect(groupingBy(String::length, toList()))
                .entrySet().stream()
                .max((t1, t2) -> t1.getValue().size() < t2.getValue().size() ? -1 : 1)
                .map(entry -> entry.getValue());

        System.out.println("teams = " + biggestTeam.get());
    }
}
