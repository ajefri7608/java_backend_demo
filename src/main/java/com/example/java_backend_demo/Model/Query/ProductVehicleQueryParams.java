package com.example.java_backend_demo.Model.Query;

import com.example.java_backend_demo.Model.ApiMsg;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductVehicleQueryParams {
    private String name;
    private Integer maxPrice;
    private Integer minimumPrice;
    private String brand;
    private Integer seatCount;
    private Integer engineSize;
    private String yearOfManufacture;
    private Integer establishedDate;
    private String productStatus;

}
