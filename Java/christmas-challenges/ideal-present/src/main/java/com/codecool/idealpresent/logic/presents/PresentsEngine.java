package com.codecool.idealpresent.logic.presents;

import com.codecool.idealpresent.data.Profile;
import com.codecool.idealpresent.logic.presents.selector.Selector;

import java.util.Set;

public class PresentsEngine {
    private final Set<Selector> selectors;

    public PresentsEngine(Set<Selector> selectors) {
        this.selectors = selectors;
    }


    public Profile matchPresents(Profile profile) {
        Set<String> presents = getPresents(profile);
        profile.presents().addAll(presents);
        return profile;
    }

    private Set<String> getPresents(Profile profile) {
        return selectors.stream()
                .filter(selector -> selector.matches(profile))
                .map(selector -> selector.getPresents(profile))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("No selector found for profile with karma: " + profile.karma()));
    }
}
