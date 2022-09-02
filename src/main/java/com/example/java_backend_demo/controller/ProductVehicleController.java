package com.example.java_backend_demo.controller;

import com.example.java_backend_demo.Model.ProductVehicle;
import com.example.java_backend_demo.Model.Query.ProductVehicleQueryParams;
import com.example.java_backend_demo.exception.GeneralException;
import com.example.java_backend_demo.Model.GeneralResponse;

import com.example.java_backend_demo.service.ProductVehicleCreateService;
import com.example.java_backend_demo.service.ProductVehicleSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(value = "/products")
public class ProductVehicleController extends BaseController{

    @Autowired
    ProductVehicleCreateService productVehicleCreateService;

    @Autowired
    ProductVehicleSearchService productVehicleSearchService;

    @PostMapping("/createVehicle")
    public GeneralResponse createVehicle(@Valid @RequestBody ProductVehicle productVehicle) throws GeneralException {
        return productVehicleCreateService.start(productVehicle);
    }

    @PostMapping("/searchVehicle")
    public GeneralResponse searchVehicle(@RequestBody ProductVehicleQueryParams productVehicleQueryParams) throws GeneralException {
        return productVehicleSearchService.start(productVehicleQueryParams);
    }




}