package com.codecool.idealpresent.logic.presents.selector;

import com.codecool.idealpresent.data.Profile;

import java.util.Set;

public class Standard implements Selector {
    private final int threshold;
    private final String present;

    public Standard(int threshold, String present) {
        this.threshold = threshold;
        this.present = present;
    }

    @Override
    public boolean matches(Profile profile) {
        return profile.karma() < threshold;
    }

    @Override
    public Set<String> getPresents(Profile profile) {
        return Set.of(present);
    }
}
