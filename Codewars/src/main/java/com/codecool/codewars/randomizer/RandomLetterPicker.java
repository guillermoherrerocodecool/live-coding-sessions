package com.codecool.codewars.randomizer;

public class RandomLetterPicker {
    private final Randomizer randomizer;

    public RandomLetterPicker(Randomizer randomizer) {
        this.randomizer = randomizer;
    }

    public String pickOneLetterAtRandom(String text) {
        String[] letters = text.split("");
        int randomIndex = randomizer.getRandomNumber(letters.length);
        return letters[randomIndex];
    }
}
