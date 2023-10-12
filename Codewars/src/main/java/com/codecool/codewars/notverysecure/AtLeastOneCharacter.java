package com.codecool.codewars.notverysecure;

public class AtLeastOneCharacter implements Check {
    @Override
    public boolean validate(String input) {
        return !input.isEmpty();
    }
}
