package com.codecool.codewars.sortandstar;

public class Star {
    public String star(String string) {
        return String.join("***", string.split(""));
    }
}
