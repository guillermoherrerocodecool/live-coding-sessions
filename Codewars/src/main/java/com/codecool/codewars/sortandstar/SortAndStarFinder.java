package com.codecool.codewars.sortandstar;

public class SortAndStarFinder {
    private final Sorter sorter;
    private final Star star;

    public SortAndStarFinder(Sorter sorter, Star star) {
        this.sorter = sorter;
        this.star = star;
    }

    // KISS - Keep It Simple Stupid
    // SLAP - Single Level of Abstraction Principle (CMP - Compose Method Pattern)
    public String find(String[] strings) {
        String[] sorted = sorter.sort(strings);
        if (sorted.length == 0) {
            return null;
        }
        String first = sorted[0];
        return star.star(first);
    }
}
