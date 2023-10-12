package com.codecool.codewars.stringrotation;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class StringRotator {
    public int rotate(String first, String second) {
        int length = first.length();
        String target = first;
        for (int numberOfRotations = 0; numberOfRotations < length; numberOfRotations++) {
            if (target.equals(second)) {
                return numberOfRotations;
            }
            target = rotateOnce(target);
        }
        return -1;
    }

    private String rotateOnce(String target) {
        List<String> letters = Stream.of(target.split("")).collect(toList());
        Collections.rotate(letters, 1);
        return String.join("", letters);
    }
}
