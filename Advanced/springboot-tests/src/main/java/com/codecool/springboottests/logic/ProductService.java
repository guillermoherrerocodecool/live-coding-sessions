package com.codecool.springboottests.logic;

import com.codecool.springboottests.persistence.Product;
import com.codecool.springboottests.persistence.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductUidGenerator productUidGenerator;

    public ProductService(ProductRepository productRepository, ProductUidGenerator productUidGenerator) {
        this.productRepository = productRepository;
        this.productUidGenerator = productUidGenerator;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product save(Product product) {
        String uid = productUidGenerator.generateUid(product);
        product.setUid(uid);
        return productRepository.save(product);
    }
}
