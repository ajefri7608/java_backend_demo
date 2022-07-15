package com.example.java_backend_demo.repository;

import com.example.java_backend_demo.Pojo.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository

public interface ProductRepository extends JpaSpecificationExecutor<Product>, JpaRepository<Product, Integer> {
    @Modifying
    @Transactional
    @Query(value = "" + "INSERT INTO PRODUCT(NAME, PRICE) "
            + "VALUES (:#{#product.getName()},:#{#product.getPrice()})", nativeQuery = true)
    int createProduct(@Param("product") Product product);

}
