package com.example.java_backend_demo.controller;

import com.example.java_backend_demo.Pojo.ProductVehicle;
import com.example.java_backend_demo.exception.GeneralException;
import com.example.java_backend_demo.Pojo.AuthRequest;
import com.example.java_backend_demo.Pojo.GeneralResponse;
import com.example.java_backend_demo.Pojo.UserPersonalInfo;

import com.example.java_backend_demo.service.JWTService;
import com.example.java_backend_demo.service.ProductVehicleCreateService;
import com.example.java_backend_demo.service.UserCreateService;
import com.example.java_backend_demo.service.UserLoginService;
import com.example.java_backend_demo.util.LocalApiMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.*;


@RestController
@RequestMapping(value = "/products")
public class ProductVehicleController extends BaseController{

    @Autowired
    ProductVehicleCreateService productVehicleCreateService;

    @PostMapping("/createVehicle")
    public GeneralResponse createVehicle(@Valid @RequestBody ProductVehicle productVehicle) throws GeneralException {
        return productVehicleCreateService.start(productVehicle);
    }

    @PostMapping("/searchVehicle")
    public GeneralResponse searchVehicle(@RequestBody ProductVehicle productVehicle) throws GeneralException {
        return productVehicleCreateService.start(productVehicle);
    }




}