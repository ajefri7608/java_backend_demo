package com.example.java_backend_demo.service;

import com.example.java_backend_demo.Model.Product;
import com.example.java_backend_demo.exception.GeneralException;
import com.example.java_backend_demo.Model.GeneralResponse;
import com.example.java_backend_demo.repository.ProductRepository;
import com.example.java_backend_demo.util.LocalApiMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCreateService extends BaseService<Product>{
    @Autowired
    ProductRepository repository;

    @Override
    protected GeneralResponse process(Product request) throws GeneralException {
        try{
           // repository.save(request);
            return returnRsp(LocalApiMsg.Success, request);
        }catch (Exception e){
            return returnRsp(LocalApiMsg.ProductCreateFail);
        }

    }


}
