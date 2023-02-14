package com.codecool.cai.interfaces;

public class EndsInDotComValidator implements Validator {
    @Override
    public boolean isValid(String email) {
        String[] parts = email.split("@");
        if (parts.length < 2) {
            return false;
        }
        return parts[1].endsWith(".com");
    }
}
