package com.example.java_backend_demo.repository;

import com.example.java_backend_demo.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository

public interface ProductRepository extends JpaSpecificationExecutor<Product>, JpaRepository<Product, Integer> {
    @Modifying
    @Transactional
    @Query(value = "" + "INSERT INTO product(id, name, price) "
            + "VALUES (:#{#product.getId()},:#{#product.getName()},:#{#product.getPrice()})", nativeQuery = true)
    void createProduct(@Param("product") Product product);
//    public ApiMessageDetail findByRefIdAndLang(Long refId, Language language){
//        ApiMessageDetail apiMessageDetail = new ApiMessageDetail();
//        try{
//            apiMessageDetail = jdbcTemplate.queryForObject("SELECT id FROM API_MESSAGE_DETAIL WHERE REF_ID = " + refId + "AND LANG = " + language, ApiMessageDetail);
//        }catch (Exception e){
//            System.out.println(e);
//        }
//        return apiMessageDetail;
//    };
    Product findById(int id);
}