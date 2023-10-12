package com.codecool.codewars.notverysecure;

public class NotAllowedCharacters implements Check {
    private final String rejected;

    public NotAllowedCharacters(String rejected) {
        this.rejected = rejected;
    }

    @Override
    public boolean validate(String input) {
        return input.chars()
                .mapToObj(Character::toString)
                .noneMatch(rejected::contains);
    }
}
