package com.example.java_backend_demo.service;

import com.example.java_backend_demo.Model.ProductVehicle;
import com.example.java_backend_demo.exception.GeneralException;
import com.example.java_backend_demo.Model.GeneralResponse;
import com.example.java_backend_demo.repository.ProductVehicleRepository;
import com.example.java_backend_demo.util.LocalApiMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductVehicleCreateService extends BaseService<ProductVehicle>{
    @Autowired
    ProductVehicleRepository repository;

    @Override
    protected GeneralResponse process(ProductVehicle request) throws GeneralException {
        try{
            repository.save(request);
            return returnRsp(LocalApiMsg.Success, request);
        }catch (Exception e){
            return returnRsp(LocalApiMsg.ProductCreateFail);
        }

    }


}
