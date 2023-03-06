package com.codecool.karmatm.logic.karma;

import com.codecool.karmatm.data.ActionType;
import com.codecool.karmatm.data.Karma;

import java.util.List;
import java.util.Set;

public class KarmaCalculator {
    public int calculate(Set<String> actions, List<Karma> karmas) {
        return actions.stream()
                .mapToInt(action -> toKarmaValue(action, karmas))
                .sum();
    }

    private int toKarmaValue(String action, List<Karma> karmas) {
        return karmas.stream()
                .filter(karma -> karma.action().equals(action))
                .map(Karma::type)
                .map(karmaType -> karmaType.equals(ActionType.NICE) ? 1 : -1)
                .findFirst()
                .orElse(0);
    }
}
