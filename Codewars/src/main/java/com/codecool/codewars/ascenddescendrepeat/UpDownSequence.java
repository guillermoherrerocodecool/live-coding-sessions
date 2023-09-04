package com.codecool.codewars.ascenddescendrepeat;

public class UpDownSequence {
    private final int minimum;
    private final int maximum;
    private int current;
    private int factor;

    public UpDownSequence(int minimum, int maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
        this.current = minimum;
        this.factor = -1;
    }

    public int next() {
        if (minimum == maximum){
            return minimum;
        }
        if (current == maximum || current == minimum) {
            factor *= -1;
        }
        int next = current;
        current += factor;
        return next;
    }
}
