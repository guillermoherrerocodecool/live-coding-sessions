package com.codecool.codewars.similarpassword;

import java.util.stream.Stream;

public class SimilarPasswordOperator {
    private static final String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private static final String vowels = "aeiou";

    public int findMinimumNumberOfOperations(String password) {
        String[] letters = password.split("");
        Target target = determineTarget(letters);
        if (target == Target.SIMILAR) {
            return 0;
        }
        int index = 0;
        int distance = 1;
        int numberOfOperations = 0;
        while (target != Target.SIMILAR) {
            if (index == letters.length) {
                index = 0;
                distance++;
            }
            String letter = letters[index];
            if (isOperationWithin(letter, distance, target)) {
                operate(index, letters, distance, target);
                numberOfOperations += distance;
                target = determineTarget(letters);
            }
            index++;
        }
        return numberOfOperations;
    }

    Target determineTarget(String[] letters) {
        int variation = Stream.of(letters)
                .mapToInt(letter -> isVowel(letter) ? -1 : 1)
                .sum();
        if (variation < 0) {
            return Target.CONSONANTS;
        }
        if (variation > 0) {
            return Target.VOWELS;
        }
        return Target.SIMILAR;
    }

    private boolean isOperationWithin(String letter, int distance, Target target) {
        if (target == Target.VOWELS) {
            if (isIncrementable(letter, distance)) {
                String shift = increment(letter, distance);
                if (isVowel(shift)) {
                    return true;
                }
            }
            if (isDecrementable(letter, distance)) {
                String shift = decrement(letter, distance);
                if (isVowel(shift)) {
                    return true;
                }
            }
        } else if (target == Target.CONSONANTS) {
            if (isIncrementable(letter, distance)) {
                String shift = increment(letter, distance);
                if (!isVowel(shift)) {
                    return true;
                }
            }
            if (isDecrementable(letter, distance)) {
                String shift = decrement(letter, distance);
                if (!isVowel(shift)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isVowel(String shift) {
        return vowels.contains(shift);
    }

    private boolean isIncrementable(String letter, int distance) {
        int index = alphabet.indexOf(letter);
        int delta = index + distance;
        return delta < alphabet.length();
    }

    private boolean isDecrementable(String letter, int distance) {
        int index = alphabet.indexOf(letter);
        int delta = index - distance;
        return delta >= 0;
    }

    private String increment(String letter, int distance) {
        int index = alphabet.indexOf(letter);
        int increment = index + distance;
        return alphabet.substring(increment, increment + 1);
    }

    private String decrement(String letter, int distance) {
        int index = alphabet.indexOf(letter);
        int decrement = index - distance;
        return alphabet.substring(decrement, decrement + 1);
    }

    private void operate(int index, String[] letters, int distance, Target target) {
        String letter = letters[index];
        if (target == Target.VOWELS) {
            if (isIncrementable(letter, distance)) {
                String shift = increment(letter, distance);
                if (isVowel(shift)) {
                    letters[index] = shift;
                    return;
                }
            }
            if (isDecrementable(letter, distance)) {
                String shift = decrement(letter, distance);
                if (isVowel(shift)) {
                    letters[index] = shift;
                    return;
                }
            }
        } else if (target == Target.CONSONANTS) {
            if (isIncrementable(letter, distance)) {
                String shift = increment(letter, distance);
                if (!isVowel(shift)) {
                    letters[index] = shift;
                    return;
                }
            }
            if (isDecrementable(letter, distance)) {
                String shift = decrement(letter, distance);
                if (!isVowel(shift)) {
                    letters[index] = shift;
                    return;
                }
            }
        }
    }
}
