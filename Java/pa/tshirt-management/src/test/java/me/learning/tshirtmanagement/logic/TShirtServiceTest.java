package me.learning.tshirtmanagement.logic;

import me.learning.tshirtmanagement.data.Color;
import me.learning.tshirtmanagement.data.Purchase;
import me.learning.tshirtmanagement.data.Size;
import me.learning.tshirtmanagement.data.TShirt;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

class TShirtServiceTest {
    TShirtService tShirtService = new TShirtService();

    public static Stream<Arguments> parameters() {
        return Stream.of(
                of(0, Set.of(), Color.RAINBOW, Size.L),
                of(0, Set.of(
                        new Purchase(null, 0, null, null,
                                new TShirt(null, null, Color.GLITTER, Size.S))
                ), Color.RAINBOW, Size.L),
                of(0, Set.of(
                        new Purchase(null, 0, null, null,
                                new TShirt(null, null, Color.RAINBOW, Size.S))
                ), Color.RAINBOW, Size.L),
                of(1, Set.of(
                        new Purchase(null, 0, null, null,
                                new TShirt(null, null, Color.RAINBOW, Size.L))
                ), Color.RAINBOW, Size.L),

                of(1, Set.of(
                        new Purchase("1", 0, null, null,
                                new TShirt(null, null, Color.GLITTER, Size.S)),
                        new Purchase("2", 0, null, null,
                                new TShirt(null, null, Color.RAINBOW, Size.L))
                ), Color.RAINBOW, Size.L),

                of(2, Set.of(
                        new Purchase("1", 0, null, null,
                                new TShirt(null, null, Color.RAINBOW, Size.L)),
                        new Purchase("2", 0, null, null,
                                new TShirt(null, null, Color.RAINBOW, Size.L))
                ), Color.RAINBOW, Size.L)

        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void calculateNumberOfTShirtsByColorAndSize(long expected, Set<Purchase> purchases, Color color, Size size) {
        long result = tShirtService.calculateNumberOfTShirtsByColorAndSize(purchases, color, size);

        assertEquals(expected, result);
    }
}