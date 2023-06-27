package com.codecool.katas

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.assertEquals

class MiddlecharacterKtTest {

    @ParameterizedTest
    @CsvSource(
        "a, a",
        "ab, ab",
        "b, abc",
        "bc, abcd",
        "t, testing",
        "es, test"
    )
    fun testFindMiddleCharacter(expected: String, input: String) {
        val result = findMiddleCharacter(input)

        assertEquals(expected, result)
    }
}