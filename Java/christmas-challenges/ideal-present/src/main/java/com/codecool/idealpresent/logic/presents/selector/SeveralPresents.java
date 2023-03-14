package com.codecool.idealpresent.logic.presents.selector;

import com.codecool.idealpresent.data.Profile;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class SeveralPresents implements Selector {
    private final int min;
    private final int numberOfPresents;
    private final Map<String, Set<String>> presentsByCategory;
    private final Random random;

    public SeveralPresents(int min, int numberOfPresents, Map<String, Set<String>> presentsByCategory, Random random) {
        this.min = min;
        this.numberOfPresents = numberOfPresents;
        this.presentsByCategory = presentsByCategory;
        this.random = random;
    }

    // composition over inheritance
    @Override
    public boolean matches(Profile profile) {
        return profile.karma() >= min;
    }

    @Override
    public Set<String> getPresents(Profile profile) {
        List<String> availablePresents = getAvailablePresents(profile);
        return choosePresents(availablePresents);
    }

    private List<String> getAvailablePresents(Profile profile) {
        return profile.categories().stream()
                .map(presentsByCategory::get)
                .flatMap(Collection::stream)
                .collect(toList());
    }

    private Set<String> choosePresents(List<String> availablePresents) {
        return IntStream.generate(() -> 0)
                .limit(numberOfPresents)
                .map(number -> random.nextInt(availablePresents.size()))
                .mapToObj(availablePresents::remove)
                .collect(toSet());
    }
}
