package com.codecool.streams;

import java.util.List;
import java.util.Optional;

public class Streams3 {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Dean", new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}),
                new Person("El", new double[]{1, 2, 3, 4, 5, 600, 7, 8, 9, 0})
        );
        Optional<Person> richest = people.stream()
                .max((person1, person2) -> person1.income()[5] - person2.income()[5] < 0.0 ? -1 : 1);
        
        richest.ifPresent(person-> System.out.println("person = " + person));
    }
}
