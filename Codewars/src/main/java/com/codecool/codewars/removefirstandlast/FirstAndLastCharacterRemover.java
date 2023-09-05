package com.codecool.codewars.removefirstandlast;

public class FirstAndLastCharacterRemover {
    public String remove(String text) {
        return text.substring(1, text.length() - 1);
    }
}
