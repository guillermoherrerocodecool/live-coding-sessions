package com.codecool.idealpresent.logic.presents.selector;

import com.codecool.idealpresent.data.Profile;

import java.util.*;

public class OnePresent implements Selector {
    private final int min;
    private final int max;
    private final Map<String, Set<String>> presentsByCategory;
    private final Random random;

    public OnePresent(int min, int max, Map<String, Set<String>> presentsByCategory, Random random) {
        this.min = min;
        this.max = max;
        this.presentsByCategory = presentsByCategory;
        this.random = random;
    }

    @Override
    public boolean matches(Profile profile) {
        return profile.karma() >= min && profile.karma() < max;
    }

    @Override
    public Set<String> getPresents(Profile profile) {
        String category = getOneRandom(profile.categories());
        Set<String> presents = presentsByCategory.get(category);
        return Set.of(getOneRandom(presents));
    }
    
    private String getOneRandom(Set<String> elements) {
        List<String> indexedElements = new ArrayList<>(elements);
        int choice = random.nextInt(indexedElements.size());
        return indexedElements.get(choice);
    }
}
