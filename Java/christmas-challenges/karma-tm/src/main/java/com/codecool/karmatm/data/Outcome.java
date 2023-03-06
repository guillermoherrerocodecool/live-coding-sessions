package com.codecool.karmatm.data;

import java.util.Set;

public record Outcome(
        String name,
        Set<String> actions,
        int karma,
        Set<String> idealPresentCategories
) {
}
