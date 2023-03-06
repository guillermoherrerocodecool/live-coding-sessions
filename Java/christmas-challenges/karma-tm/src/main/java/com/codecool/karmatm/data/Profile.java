package com.codecool.karmatm.data;

import java.util.Set;

public record Profile(String name, Set<String> actions, Set<String> idealPresentCategories) {
}
