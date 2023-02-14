package com.codecool.cai.interfaces;

import java.util.List;

// SOLID - O - OCP - Open Closed Principle
// Open for extension, Closed to modification
public class EmailValidator {
    private final List<Validator> validators;

    public EmailValidator(List<Validator> validators) {
        this.validators = validators;
    }

    public boolean isValid(String email) {
        for (Validator validator : validators) {
            if (!validator.isValid(email)) {
                return false;
            }
        }
        return true;
    }
}
