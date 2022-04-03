package com.example.java_backend_demo.pojo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
public class User {

    private Long id;
    private String name;
    private Integer age;
}
