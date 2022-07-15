package com.example.java_backend_demo.service;

import com.example.java_backend_demo.exception.GeneralException;
import com.example.java_backend_demo.Pojo.GeneralResponse;
import com.example.java_backend_demo.Pojo.Product;
import com.example.java_backend_demo.repository.ProductRepository;
import com.example.java_backend_demo.util.LocalApiMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCreateService extends BaseService<Product>{
    @Autowired
    ProductRepository repository;


    @Override
    protected GeneralResponse process(Product product) throws GeneralException {
        repository.createProduct(product);
        return returnRsp(LocalApiMsg.Success);
    }


}
