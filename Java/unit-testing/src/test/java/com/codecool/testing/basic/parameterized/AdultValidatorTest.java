package com.codecool.testing.basic.parameterized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AdultValidatorTest {
    AdultValidator validator = new AdultValidator();

    // 80%/18%/2%

    @ParameterizedTest
    @ValueSource(ints = {18, 19})
    void isAdultReturnsTrue(int age) { // AAA
        boolean result = validator.isAdult(age);

        assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 16, 17})
    void isAdultReturnsFalse(int age) { // AAA
        boolean result = validator.isAdult(age);

        assertFalse(result);
    }
}