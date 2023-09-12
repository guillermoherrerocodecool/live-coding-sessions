package com.codecool.codewars.randomizer;

import java.util.Random;

public class Randomizer {
    private final Random random;

    public Randomizer(Random random) {
        this.random = random;
    }

    public int getRandomNumber(int ceil) {
        return random.nextInt(ceil);
    }
}
