package com.codecool.codewars.piglatin;

public class PigLatinConverter2 {
    public String convert(String text) {
        char[] characters = text.toCharArray();
        String word = "";
        String output = "";
        for (char character : characters) {
            if (Character.isLetter(character)) {
                word += character;
            } else {
                String transformed = transform(word);
                output += transformed + character;
                word = "";
            }
        }
        return output + transform(word);
    }

    private String transform(String word) {
        if (word.length() == 0) {
            return "";
        }
        int last = word.length();
        int previousToLast = last - 1;
        return word.substring(1) + word.charAt(0) + "ay";
    }
}
