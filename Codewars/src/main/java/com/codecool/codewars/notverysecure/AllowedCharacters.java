package com.codecool.codewars.notverysecure;

public class AllowedCharacters implements Check {
    private final String allowed;

    public AllowedCharacters(String allowed) {
        this.allowed = allowed;
    }

    @Override
    public boolean validate(String input) {
        return input.chars()
                .mapToObj(Character::toString)
                .allMatch(allowed::contains);
    }
}
