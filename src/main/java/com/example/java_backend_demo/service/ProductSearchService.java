package com.example.java_backend_demo.service;

import com.example.java_backend_demo.Model.GeneralResponse;
import com.example.java_backend_demo.Model.Product;
import com.example.java_backend_demo.Model.Product;
import com.example.java_backend_demo.Model.Query.ProductQueryParams;
import com.example.java_backend_demo.exception.GeneralException;
import com.example.java_backend_demo.repository.ProductRepository;
import com.example.java_backend_demo.util.LocalApiMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductSearchService extends BaseService<String>{
    @Autowired
    ProductRepository repository;

    @Override
    protected GeneralResponse process(String name) throws GeneralException {
        //ArrayList<ProductVehicle> products= new ArrayList<>();
        ArrayList<Product> products= repository.findByNameContaining(name);

        return returnRsp(LocalApiMsg.Success, products);

    }


}