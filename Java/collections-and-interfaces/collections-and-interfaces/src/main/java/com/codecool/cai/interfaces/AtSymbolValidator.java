package com.codecool.cai.interfaces;

public class AtSymbolValidator implements Validator {
    @Override
    public boolean isValid(String email) {
        return email.contains("@");
    }
}
