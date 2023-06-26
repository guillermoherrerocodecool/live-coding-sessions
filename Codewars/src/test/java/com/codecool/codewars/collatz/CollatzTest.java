package com.codecool.codewars.collatz;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CollatzTest {
    String delimiter = "->";
    Collatz collatz = new Collatz(delimiter);

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "2->1, 2",
            "3->10->5->16->8->4->2->1, 3",
            "4->2->1, 4",
            "5->16->8->4->2->1, 5",
            "9->28->14->7->22->11->34->17->52->26->13->40->20->10->5->16->8->4->2->1, 9",
            "50->25->76->38->19->58->29->88->44->22->11->34->17->52->26->13->40->20->10->5->16->8->4->2->1, 50",
    })
    void collatz(String expected, int number) {
        String result = collatz.collatz(number);

        assertEquals(expected, result);
    }
}