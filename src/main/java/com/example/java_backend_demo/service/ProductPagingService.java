package com.example.java_backend_demo.service;
import com.example.java_backend_demo.Model.GeneralResponse;
import com.example.java_backend_demo.Model.PaginateProductRequest;
import com.example.java_backend_demo.Model.Product;
import com.example.java_backend_demo.exception.GeneralException;
import com.example.java_backend_demo.repository.ProductRepository;
import com.example.java_backend_demo.util.LocalApiMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
public class ProductPagingService extends BaseService<PaginateProductRequest> {
    @Autowired
    ProductRepository repository;

    @Override
    protected GeneralResponse process(PaginateProductRequest request) throws GeneralException {


        try{
            Page<Product> products =  repository.findAll(PageRequest.of(request.getPage(),request.getElementEachPage()));
            return returnRsp(LocalApiMsg.Success, products.getContent());
        }catch (Exception e ){
            throw new GeneralException(LocalApiMsg.ProductListPageNotFound);

        }




    }
}
