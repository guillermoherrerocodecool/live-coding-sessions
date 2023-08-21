package com.codecool.codewars.validparentheses;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParenthesesValidator3Test {
    ParenthesesValidator3 validator = new ParenthesesValidator3();

    @ParameterizedTest
    @CsvSource({
            "true, ''",
            "false, (",
            "false, )",
            "false, )(",
            "true, ()",
            "true, (())",
            "true, ()()",
            "false, )()(",

            "true, ((()))",
            "true, ()()()",
            "true, (()())()",
            "true, ()(())((()))(())()",
            "false, )(",
            "false, ()()(",
            "false, ((())",
            "false, ())(()",
            "false, )()",
            "false, )",
    })
    void validate(boolean expected, String parentheses) {
        boolean result = validator.validate(parentheses);

        assertEquals(expected, result);
    }
}