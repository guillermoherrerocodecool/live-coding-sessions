package com.codecool.springboottests.logic;

import com.codecool.springboottests.persistence.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Set;


class ProductUidGeneratorTest {
    ProductUidGenerator productUidGenerator = new ProductUidGenerator();

    @ParameterizedTest
    @CsvSource({
            "uid-, ''",
            "uid-a, a",
            "uid-1, 1",
            "uid-ab, ab",
            "uid-a1, a1",
            "uid-aA, aA",
    })
    void generateUid(String expected, String name) {
        Product product = new Product(name, Set.of(), 0.0, null);
        String result = productUidGenerator.generateUid(product);

        Assertions.assertEquals(expected, result);
    }
}