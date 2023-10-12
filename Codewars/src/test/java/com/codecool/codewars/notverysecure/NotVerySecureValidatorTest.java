package com.codecool.codewars.notverysecure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import java.util.List;


class NotVerySecureValidatorTest {
    Check check1 = Mockito.mock(Check.class);
    Check check2 = Mockito.mock(Check.class);
    NotVerySecureValidator validator = new NotVerySecureValidator(List.of(check1, check2));

    @ParameterizedTest
    @CsvSource({
            "false, false, false, 1, 0",
            "false, false, true, 1, 0",
            "false, true, false, 1, 1",
            "true, true, true, 1, 1",
    })
    void validateReturnsTrueAllChecksTrue(boolean expected, boolean check1return, boolean check2return, int timesCheck1, int timesCheck2) {
        String input = "input";
        Mockito.when(check1.validate(input)).thenReturn(check1return);
        Mockito.when(check2.validate(input)).thenReturn(check2return);

        boolean result = validator.validate(input);

        Assertions.assertEquals(expected, result);
        Mockito.verify(check1, Mockito.times(timesCheck1)).validate(input);
        Mockito.verify(check2, Mockito.times(timesCheck2)).validate(input);
    }
}