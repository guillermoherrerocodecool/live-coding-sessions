package com.codecool.codewars.piglatin;

public class PigLatinConverter {
    public String convert(String text) {
        return text.replaceAll("(\\w)(\\w*)", "$2$1ay");
    }
}
