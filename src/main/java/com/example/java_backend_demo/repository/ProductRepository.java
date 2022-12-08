package com.example.java_backend_demo.repository;


import com.example.java_backend_demo.Model.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {
    @Modifying
    @Transactional
    @Query(value = "" + "INSERT INTO PRODUCT_VEHICLE(ID, NAME, PRICE, BRAND, SEAT_COUNT, ENGINE_SIZE, YEAR_OF_MANUFACTURE, ESTABLISHED_DATE, LAST_MODIFY_DATE,MODIFY_BY, DESCRIPTION, PRODUCT_STATUS) "
            + "VALUES (:#{#productVehicle.getId()}, :#{#productVehicle.getName()}," +
            ":#{#productVehicle.getPrice()}, , :#{#productVehicle.getProductStatus()}" +
            ":#{#productVehicle.getBrand()}, :#{#productVehicle.getSeatCount()})" +
            ":#{#productVehicle.getEngineSize()}, :#{#productVehicle.getYearOfManufacture()}, " +
            ":#{#productVehicle.getEstablishedDate()}, :#{#productVehicle.getLastModifyDate()}, " +
            ":#{#productVehicle.getModifyBy()}, :#{#productVehicle.getDescription() ", nativeQuery = true)
    Integer createProduct(@Param("product") Product product);

    ArrayList<Product> findByNameContaining(String name);

    ArrayList<Product> findByPriceBetween(Integer lowestPrice, Integer highestPrice);
//    public ArrayList<Product> findAllStudentsWithJpql() {
//        return session.createQuery("SELECT a FROM Student a", Student.class).getResultList();
//    }

}
