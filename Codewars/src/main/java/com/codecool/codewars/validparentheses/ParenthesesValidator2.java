package com.codecool.codewars.validparentheses;

public class ParenthesesValidator2 {
    public boolean validate(String parentheses) {
        while (parentheses.contains("()")) {
            parentheses = parentheses.replaceAll("\\(\\)", "");
        }
        return parentheses.isEmpty();
    }
}
