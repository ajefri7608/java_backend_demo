package com.example.java_backend_demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "PRODUCT_VEHICLE_IMAGE")
@NoArgsConstructor
@AllArgsConstructor
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private String id;
    @Column(name = "FILE_PATH")
    private String filePath;
    @Column(name = "PRODUCT_ID")
    private String productId;

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
