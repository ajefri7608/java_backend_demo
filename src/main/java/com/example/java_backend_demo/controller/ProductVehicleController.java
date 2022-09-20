package com.example.java_backend_demo.controller;

import com.example.java_backend_demo.Model.ProductVehicle;
import com.example.java_backend_demo.Model.Query.ProductVehicleQueryParams;
import com.example.java_backend_demo.exception.GeneralException;
import com.example.java_backend_demo.Model.GeneralResponse;

import com.example.java_backend_demo.service.ProductVehicleCreateService;
import com.example.java_backend_demo.service.ProductVehicleSearchService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.ServletContext;
import javax.validation.Valid;



@RestController
@RequestMapping(value = "/products")
public class ProductVehicleController extends BaseController{
    @Value("${SavePath.Image}")
    private String ImagePath;

    @Value("${SavePath.ImageMapper}")
    private String ImageMapperPath;



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
    @PostMapping("imageUploadTest")
    public String ImageUploadTest(@RequestParam("file") MultipartFile file){
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        fileName = UUID.randomUUID() + suffixName;

        try{

            file.transferTo(new File(ImagePath + fileName));
            return ImageMapperPath + fileName;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

    }
    @GetMapping(value = "imageDisplayTest", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[]  imageDisplayTest(@RequestParam(name = "string") String filePath){
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(ImagePath + "/" + filePath));
            return bytes;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }






}