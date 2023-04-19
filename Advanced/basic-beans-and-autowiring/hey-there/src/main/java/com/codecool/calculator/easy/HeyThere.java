package com.codecool.calculator.easy;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class HeyThere {
    private final Hey hey;
    private final There there;
    private final List<Punctuation> punctuations;


    public HeyThere(Hey hey, There there, List<Punctuation> punctuations) {
        this.hey = hey;
        this.there = there;
        this.punctuations = punctuations;
    }

    public String message() {
        return hey.getMessage() + " " +
                there.getMessage() +
                punctuations.stream()
                        .map(Punctuation::getMessage)
                        .collect(Collectors.joining());
    }
}
