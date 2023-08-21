package com.codecool.codewars.tidynumber;

public class TidyNumberValidator {
    public boolean isTidyNumber(int number) {
        char[] characters = String.valueOf(number).toCharArray();
        char previous = characters[0];
        for (char current : characters) {
            if (current < previous) {
                return false;
            }
            previous = current;
        }
        return true;
    }
}
