package com.codecool.springboottests.logic;

import com.codecool.springboottests.persistence.Product;
import com.codecool.springboottests.persistence.ProductRepository;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class ProductServiceTest {
    ProductRepository productRepository = mock(ProductRepository.class);
    ProductUidGenerator productUidGenerator = mock(ProductUidGenerator.class);
    ProductService productService = new ProductService(productRepository, productUidGenerator);

    @Test
    void findAll() {
        productService.findAll();

        verify(productRepository).findAll();
    }

    @Test
    void save() {
        Product product = new Product("test", Set.of(), 0.0, null);
        when(productUidGenerator.generateUid(product)).thenReturn("test");

        Product result = productService.save(product);

//        assertEquals(result.getName(), product.getName());
//        assertEquals(result.getIngredients(), product.getIngredients());
//        assertEquals(result.getPrice(), product.getPrice());
//        assertNotNull(result.getUid());

        verify(productUidGenerator).generateUid(product);
        verify(productRepository).save(product);
    }
}