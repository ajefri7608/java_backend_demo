package com.example.java_backend_demo.service;

import com.example.java_backend_demo.Model.GeneralResponse;
import com.example.java_backend_demo.Model.ProductVehicle;
import com.example.java_backend_demo.Model.Query.ProductVehicleQueryParams;
import com.example.java_backend_demo.exception.GeneralException;
import com.example.java_backend_demo.repository.ProductVehicleRepository;
import com.example.java_backend_demo.util.LocalApiMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductVehicleSearchService extends BaseService<ProductVehicleQueryParams>{
    @Autowired
    ProductVehicleRepository repository;

    @Override
    protected GeneralResponse process(ProductVehicleQueryParams request) throws GeneralException {
        //ArrayList<ProductVehicle> products= new ArrayList<>();
        ArrayList<ProductVehicle> products= repository.findByNameContaining(request.getName());
        return returnRsp(LocalApiMsg.Success, products);

    }


}
