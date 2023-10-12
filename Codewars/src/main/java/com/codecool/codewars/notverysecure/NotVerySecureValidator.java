package com.codecool.codewars.notverysecure;

import java.util.List;

public class NotVerySecureValidator {
    private final List<Check> checks;

    public NotVerySecureValidator(List<Check> checks) {
        this.checks = checks;
    }

    public boolean validate(String input) {
        return checks.stream()
                .allMatch(check -> check.validate(input));
    }
}
