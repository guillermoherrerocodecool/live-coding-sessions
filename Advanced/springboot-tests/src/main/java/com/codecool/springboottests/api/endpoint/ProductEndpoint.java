package com.codecool.springboottests.api.endpoint;

import com.codecool.springboottests.logic.ProductService;
import com.codecool.springboottests.persistence.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductEndpoint {
    private final ProductService productService;

    public ProductEndpoint(ProductService productService) {
        this.productService = productService;
    }
    
    @GetMapping
    List<Product> getAll(){
        return productService.findAll();
    }
    
    @PostMapping
    Product add(@RequestBody Product product){
        return productService.save(product);
    }
}
