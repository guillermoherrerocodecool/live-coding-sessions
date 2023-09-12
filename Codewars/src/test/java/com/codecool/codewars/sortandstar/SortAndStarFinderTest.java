package com.codecool.codewars.sortandstar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SortAndStarFinderTest {
    Sorter sorter = Mockito.mock(Sorter.class);
    Star star = Mockito.mock(Star.class);
    SortAndStarFinder finder = new SortAndStarFinder(sorter, star);

    @Test
    void findReturnsNull() {
        String[] strings = new String[]{};
        Mockito.when(sorter.sort(strings)).thenReturn(strings);

        String result = finder.find(strings);

        String expected = null;
        Assertions.assertEquals(expected, result);
        Mockito.verify(sorter).sort(strings);
        Mockito.verify(star, Mockito.never()).star(Mockito.anyString());
    }

    // DRY - Don't Repeat Yourself
    // WET - Waste Everyone's Time (by copy-pasting code)
    @Test
    void findReturnsString() {
        String[] strings = new String[]{"a" };
        Mockito.when(sorter.sort(strings)).thenReturn(strings);
        Mockito.when(star.star("a")).thenReturn("a");

        String result = finder.find(strings);

        String expected = "a";
        Assertions.assertEquals(expected, result);
        Mockito.verify(sorter).sort(strings);
        Mockito.verify(star).star("a");
    }
}