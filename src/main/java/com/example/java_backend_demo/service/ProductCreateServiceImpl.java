package com.example.java_backend_demo.service;

import com.example.java_backend_demo.exception.ExceptionHandle;
import com.example.java_backend_demo.pojo.GeneralResponse;
import com.example.java_backend_demo.pojo.Product;
import com.example.java_backend_demo.repository.ProductRepository;
import com.example.java_backend_demo.util.LocalApiMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCreateServiceImpl extends BaseService<Product>{
    @Autowired
    ProductRepository repository;


    @Override
    protected GeneralResponse process(Product product) throws ExceptionHandle {
        repository.createProduct(product);
        return returnRsp(LocalApiMsg.Success);
    }


}
