package com.example.java_backend_demo.repository;


import com.example.java_backend_demo.Pojo.ProductVehicle;
import com.example.java_backend_demo.Pojo.UserPersonalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Repository
public interface ProductVehicleRepository extends JpaSpecificationExecutor<ProductVehicle>, JpaRepository<ProductVehicle, Integer> {
    @Modifying
    @Transactional
    @Query(value = "" + "INSERT INTO PRODUCT_VEHICLE(ID, NAME, PRICE, BRAND, SEAT_COUNT, ENGINE_SIZE, YEAR_OF_MANUFACTURE, ESTABLISHED_DATE, LAST_MODIFY_DATE,MODIFY_BY, DESCRIPTION, PRODUCT_STATUS) "
            + "VALUES (:#{#productVehicle.getId()}, :#{#productVehicle.getName()}," +
            ":#{#productVehicle.getPrice()}, , :#{#productVehicle.getProductStatus()}" +
            ":#{#productVehicle.getBrand()}, :#{#productVehicle.getSeatCount()})" +
            ":#{#productVehicle.getEngineSize()}, :#{#productVehicle.getYearOfManufacture()}, " +
            ":#{#productVehicle.getEstablishedDate()}, :#{#productVehicle.getLastModifyDate()}, " +
            ":#{#productVehicle.getModifyBy()}, :#{#productVehicle.getDescription() ", nativeQuery = true)
    Integer createProductVehicle(@Param("productVehicle") ProductVehicle productVehicle);


    @Query(value = "SELECT * FROM PRODUCT_VEHICLE WHERE NAME LIKE :#{#productVehicle.getName()} OR  ", nativeQuery = true)
    ArrayList<ProductVehicle> findProductVehicle(@Param("productVehicle") ProductVehicle productVehicle);
}
