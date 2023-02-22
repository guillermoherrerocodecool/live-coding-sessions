package com.codecool.springboottests.logic;

import com.codecool.springboottests.persistence.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductUidGenerator {
    public String generateUid(Product product) {
        String name = product.getName();
        return "uid-" + name;
    }
}
