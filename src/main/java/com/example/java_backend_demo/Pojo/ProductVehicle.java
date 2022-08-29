package com.example.java_backend_demo.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "PRODUCT_VEHICLE")
@NoArgsConstructor
@AllArgsConstructor
public class ProductVehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private String id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "PRICE")
    private Integer price;
    @Column(name = "BRAND")
    private String brand;
    @Column(name = "SEAT_COUNT")
    private Integer seatCount;
    @Column(name = "ENGINE_SIZE")
    private Integer engineSize;
    @Column(name = "YEAR_OF_MANUFACTURE")
    private String yearOfManufacture;
    @Column(name = "ESTABLISHED_DATE")
    private Integer establishedDate;
    @Column(name = "LAST_MODIFY_DATE")
    private Integer lastModifyDate;
    @Column(name = "MODIFY_BY")
    private String modifyBy;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "PRODUCT_STATUS")
    private String productStatus;
//    public ProductVehicle() {
//
//    }

//    public ProductVehicle(String name, Integer price, String brand, Integer seatCount, Integer engineSize,
//                          String yearOfManufacture, String establishedDate, String lastModifyDate, String modifyBy, String description, String productStatus) {
//        this.name = name;
//        this.price = price;
//
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getPrice() {
//        return price;
//    }
//
//    public void setPrice(int price) {
//        this.price = price;
//    }
}
