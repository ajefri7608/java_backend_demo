package com.example.java_backend_demo.Model;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDetailResponse {
    private Integer id;
    private String name;
    private Integer price;
    private String brand;
    private Integer seatCount;
    private Integer engineSize;
    private String yearOfManufacture;
    private Integer establishedDate;
    private Integer lastModifyDate;
    private String modifyBy;
    private String description;
    private String productStatus;
    private Integer numOfDoor;
    private String fuelType;
    private String used;

    public ProductDetailResponse(Product product){
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.brand = product.getBrand();
        this.seatCount = product.getSeatCount();
        this.engineSize = product.getEngineSize();
        this.yearOfManufacture = product.getYearOfManufacture();
        this.establishedDate = product.getEstablishedDate();
        this.lastModifyDate = product.getLastModifyDate();
        this.modifyBy = product.getModifyBy();
        this.description = product.getDescription();
        this.productStatus = product.getProductStatus();
        this.numOfDoor = product.getNumOfDoor();
        this.fuelType = product.getFuelType();
        this.used = product.getUsed();
    }

}
