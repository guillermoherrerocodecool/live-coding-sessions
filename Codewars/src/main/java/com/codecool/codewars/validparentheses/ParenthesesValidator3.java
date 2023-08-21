package com.codecool.codewars.validparentheses;

public class ParenthesesValidator3 {
    private final String regex = "\\((?:[^)(]|\\((?:[^)(]|\\((?:[^)(]|\\([^)(]*\\))*\\))*\\))*\\)";

    public boolean validate(String parentheses) {
        return parentheses.replaceAll(regex, "").length() == 0;
    }
}
