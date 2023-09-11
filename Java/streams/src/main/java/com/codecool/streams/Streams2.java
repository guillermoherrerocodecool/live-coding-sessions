package com.codecool.streams;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Streams2 {
    public static void main(String[] args) {
        List<List<String>> teams = List.of(
                List.of("Tobias", "Mona", "Christopher"),
                List.of("Vahe", "David", "Dora"),
                List.of("Grazyna"),
                List.of("Paul", "Gabriel"));

        List<List<String>> bigTeams = teams.stream()
                .filter(team -> team.size() > 2)
                .collect(Collectors.toList());
        System.out.println("bigTeams = " + bigTeams);

        List<String> mentorReview = bigTeams.stream()
                .flatMap(team -> team.stream().limit(1))
                .limit(2)
                .map(name -> name.toUpperCase())
                .collect(Collectors.toList());
        System.out.println("mentorReview = " + mentorReview);
        Optional<String> longestName = mentorReview.stream()
                .max((name1, name2) -> name1.length() - name2.length());
        longestName.ifPresent(longest -> System.out.println("longest = " + longest));
    }
}
