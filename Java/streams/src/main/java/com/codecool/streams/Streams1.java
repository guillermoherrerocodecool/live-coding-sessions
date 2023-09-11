package com.codecool.streams;

import java.util.List;

public class Streams1 {
    public static void main(String[] args) {
        List<String> names = List.of("Vahe", "Tobias", "Mona", "David", "Gabriel", "Dora", "Dean");
        names.stream()
                .skip(1)
                .filter(name -> name.length() < 6) // should I keep this?
                .skip(1)
                .sorted()
                .skip(2)
                .forEach(name -> System.out.println(name));

    }

    public String doSomething(String somethingElse) {
        // do something
        return "bla";
    }

    // name$, return type, access keyword, parameters/arguments, body!
}
