package com.example.java_backend_demo.service;

import com.example.java_backend_demo.pojo.ApiMsg;
import com.example.java_backend_demo.pojo.Product;
import com.example.java_backend_demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends BaseService<Product>{
    @Autowired
    ProductRepository productRepository;
    public void createProduct(Product product){
        try{
            productRepository.createProduct(product);
        }catch (Exception e){
            System.out.println(e);
        }

    }

//    public Product replaceProduct(String id, Product request) {
//        Product oldProduct = getProduct(id);
//
//        Product product = new Product();
//        product.setId(oldProduct.getId());
//        product.setName(request.getName());
//        product.setPrice(request.getPrice());
//
//        return repository.save(product);
//    }
//
//    public void deleteProduct(String id) {
//        repository.deleteById(id);
//    }


}
