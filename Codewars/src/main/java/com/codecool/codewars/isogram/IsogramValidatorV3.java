package com.codecool.codewars.isogram;


import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class IsogramValidatorV3 {

    public boolean isIsogram(String text) {
        Set<String> letters = Arrays.stream(text.split(""))
                .map(String::toLowerCase)
                .collect(Collectors.toSet());
        return text.length() == letters.size();
    }
}
