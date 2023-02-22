package com.codecool.springboottests.api.endpoint;

import com.codecool.springboottests.logic.ProductService;
import com.codecool.springboottests.persistence.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Set;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductEndpoint.class)
class ProductEndpointTest {

    @MockBean
    ProductService productService;

    @Autowired
    MockMvc mockMvc;

    String url = "/products";

    @Test
    void getAll() throws Exception {
        mockMvc.perform(get(url))
                .andExpect(status().isOk());

        verify(productService).findAll();
    }

    @Test
    void add() throws Exception {
        Product product = new Product("french-fries", Set.of("french", "fries"), 2.5, null);
        String json = """
                {"name": "french-fries",
                "ingredients":["french", "fries"],
                "price":2.5}
                """;
        when(productService.save(product)).thenReturn(product);

        mockMvc.perform(post(url)
                        .contentType(APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());

        verify(productService).save(product);
    }
}