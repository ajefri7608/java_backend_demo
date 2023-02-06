package com.example.java_backend_demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "PRODUCT_VEHICLE")
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
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
    @Column(name = "NUM_OF_DOOR")
    private Integer numOfDoor;
    @Column(name = "FUEL_TYPE")
    private String fuelType;
    @Column(name = "USED")
    private String used;


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PRODUCT_ID", updatable = false)
    private List<ProductImage> images;

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
