package com.codecool.codewars.nextbiggernumber;

import java.util.HashSet;
import java.util.Set;

public class NextBiggerNumberFinder {
    public long find(long number) {
        String digits = String.valueOf(number);
        Set<String> permutations = new HashSet<>();
        permute(digits, "", permutations);
        return permutations.stream()
                .filter(permutation -> permutation.compareTo(digits) > 0)
                .sorted()
                .map(Long::parseLong)
                .findFirst()
                .orElse(-1L);
    }

    private void permute(String original, String permutation, Set<String> results) {
        if (original.isEmpty()) {
            results.add(permutation);
            return;
        }
        for (int index = 0; index < original.length(); index++) {
            char digit = original.charAt(index);
            String rest = original.substring(0, index) + original.substring(index + 1);
            permute(rest, permutation + digit, results);
        }
    }
}
