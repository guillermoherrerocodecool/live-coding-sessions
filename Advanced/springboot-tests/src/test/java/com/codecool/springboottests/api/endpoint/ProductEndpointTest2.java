package com.codecool.springboottests.api.endpoint;

import com.codecool.springboottests.logic.ProductService;
import com.codecool.springboottests.persistence.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Set;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class ProductEndpointTest2 {

    @MockBean
    ProductService productService;

    @Autowired
    WebTestClient webTestClient;

    String url = "/products";

    @Test
    void getAll() {
        webTestClient.get()
                .uri(url)
                .exchange()
                .expectStatus()
                .is2xxSuccessful();

        verify(productService).findAll();
    }

    @Test
    void add() {
        Product product = new Product("teste", Set.of(), 0.0, "uid");
        when(productService.save(product)).thenReturn(product);
       
        webTestClient.post()
                .uri(url)
                .contentType(APPLICATION_JSON)
                .bodyValue(product)
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody(Product.class)
                .isEqualTo(product);

        verify(productService).save(product);
    }
}