package com.example.java_backend_demo.controller;


import com.example.java_backend_demo.exception.ExceptionHandle;
import com.example.java_backend_demo.pojo.GeneralResponse;
import com.example.java_backend_demo.pojo.Product;
import com.example.java_backend_demo.service.ProductCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {
    @Autowired
    private ProductCreateService productService;


    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable("id") int id) {
        Product product = new Product();
        product.setName("Romantic Story");
        product.setPrice(200);

        return product;
    }

    @PostMapping("/createProduct")
    public GeneralResponse createProduct(@RequestBody Product product) throws ExceptionHandle {
        return productService.start(product);

    }
}
