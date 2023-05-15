package com.codecool.codewars.isogram;

public class IsogramValidatorV2 {
    public boolean isIsogramV2(String text) {
        return text.chars()
                .map(Character::toLowerCase)
                .distinct()
                .count() == text.length();
    }
}
