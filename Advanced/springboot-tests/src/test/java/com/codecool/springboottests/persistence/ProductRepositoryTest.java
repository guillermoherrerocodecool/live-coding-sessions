package com.codecool.springboottests.persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    Product product = new Product("test", Set.of(), 0.0, null);

    @BeforeEach
    void before() {
        productRepository.save(product);
    }

    @AfterEach
    void after() {
        productRepository.delete(product);
    }

    @Test
    void findByNameFindsOne() {
        String name = "test";
        Optional<Product> oProduct = productRepository.findByName(name);

        assertTrue(oProduct.isPresent());
        assertEquals(name, oProduct.get().getName());
    }

    @Test
    void findByNameFindsNone() {
        String name = "not-found";
        Optional<Product> oProduct = productRepository.findByName(name);

        assertTrue(oProduct.isEmpty());
    }
}