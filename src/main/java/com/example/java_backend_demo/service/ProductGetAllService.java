package com.example.java_backend_demo.service;

import com.example.java_backend_demo.Model.GeneralResponse;
import com.example.java_backend_demo.Model.Product;
import com.example.java_backend_demo.exception.GeneralException;
import com.example.java_backend_demo.repository.ProductRepository;
import com.example.java_backend_demo.util.LocalApiMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductGetAllService extends BaseService<Integer>{
    @Autowired
    ProductRepository productRepository;

    @Override
    protected GeneralResponse process(Integer request) throws GeneralException {
        Iterable<Product> products =  productRepository.findAll();

        return new GeneralResponse(LocalApiMsg.Success, products);
    }
}
