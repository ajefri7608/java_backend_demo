package com.example.java_backend_demo.service;

import com.example.java_backend_demo.Model.GeneralResponse;
import com.example.java_backend_demo.Model.Product;
import com.example.java_backend_demo.exception.GeneralException;
import com.example.java_backend_demo.repository.ProductRepository;
import com.example.java_backend_demo.util.LocalApiMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ProductSearchService extends BaseService<Integer>{
    @Autowired
    ProductRepository repository;

    @Override
    protected GeneralResponse process(Integer id) throws GeneralException {
        //ArrayList<ProductVehicle> products= new ArrayList<>();
        Product products= repository.findById(id).orElseThrow(() -> new GeneralException(LocalApiMsg.ProductNotFound));

        return returnRsp(LocalApiMsg.Success, products);

    }


}
