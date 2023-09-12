package com.codecool.codewars.randomizer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RandomLetterPickerTest {
    Randomizer randomizer = Mockito.mock(Randomizer.class);
    RandomLetterPicker picker = new RandomLetterPicker(randomizer);

    @Test
    void pickOneLetterAtRandom() {
        String text = "text";
        Mockito.when(randomizer.getRandomNumber(text.length())).thenReturn(0);

        String result = picker.pickOneLetterAtRandom(text);

        String expected = "t";
        Assertions.assertEquals(expected, result);
    }
}