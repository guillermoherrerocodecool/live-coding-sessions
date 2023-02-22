package com.codecool.springboottests.runner;

import com.codecool.springboottests.persistence.Product;
import com.codecool.springboottests.persistence.ProductRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties("mcdonalds")
public class ProductPopulator {
    List<Product> products;

    @Bean
    ApplicationRunner populate(ProductRepository productRepository) {
        return args -> {
            productRepository.saveAll(products);
        };
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
