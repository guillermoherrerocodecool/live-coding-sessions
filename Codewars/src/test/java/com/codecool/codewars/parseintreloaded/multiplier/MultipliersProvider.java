package com.codecool.codewars.parseintreloaded.multiplier;

import java.util.List;

public class MultipliersProvider {
    private final List<Multiplier> multipliers = List.of(
            new Multiplier("billion", 1000000000),
            new Multiplier("million", 1000000),
            new Multiplier("thousand", 1000),
            new Multiplier("hundred", 100)
    );

    public List<Multiplier> getMultipliers() {
        return multipliers;
    }
}
