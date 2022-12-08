package com.example.java_backend_demo.controller;
import com.example.java_backend_demo.Model.PaginateProductRequest;
import com.example.java_backend_demo.Model.Product;
import com.example.java_backend_demo.exception.GeneralException;
import com.example.java_backend_demo.Model.GeneralResponse;
import com.example.java_backend_demo.service.ProductCreateService;
import com.example.java_backend_demo.service.ProductPagingService;
import com.example.java_backend_demo.service.ProductSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;

import javax.validation.Valid;


@RestController
@RequestMapping(value = "/products")
public class ProductController extends BaseController {
    @Value("${SavePath.Image}")
    private String ImagePath;

    @Value("${SavePath.ImageMapper}")
    private String ImageMapperPath;


    @Autowired
    ProductCreateService productCreateService;

    @Autowired
    ProductSearchService productSearchService;

    @Autowired
    ProductPagingService productPagingService;

    @PostMapping("/createProduct")
    public GeneralResponse createProduct(@Valid @RequestBody Product product) throws GeneralException {
        return productCreateService.start(product);
    }

    @GetMapping("/searchById")
    public GeneralResponse searchProductById(@RequestParam(name = "id") Integer id) throws GeneralException {
        return productSearchService.start(id);
    }

    @GetMapping("/getAllProduct")
    public GeneralResponse getAllProduct(@RequestBody PaginateProductRequest request) throws GeneralException {
        return productPagingService.start(request);
    }

    @PostMapping("/imageUpload")
    public String imageUpload(@RequestParam("file") MultipartFile file) {
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        fileName = UUID.randomUUID() + suffixName;

        try {
            file.transferTo(new File(ImagePath + fileName));
            return ImageMapperPath + fileName;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

    }

    @GetMapping(value = "/image", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getProductImage(@RequestParam(name = "path") String filePath) {
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(ImagePath + "/" + filePath));
            return bytes;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}