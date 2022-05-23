package com.example.java_backend_demo.controller;


import com.example.java_backend_demo.pojo.Product;
import com.example.java_backend_demo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;


    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable("id") int id) {
        Product product = new Product();
        product.setId(id);
        product.setName("Romantic Story");
        product.setPrice(200);

        return product;
    }

    @PostMapping("/products")
    public void createProduct(@RequestBody Product request) {

        Product product = new Product();
        product.setId(request.getId());
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        //productDB.add(product);
        productService.createProduct(product);

    }
}
