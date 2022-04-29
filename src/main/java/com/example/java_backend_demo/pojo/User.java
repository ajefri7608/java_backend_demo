package com.example.java_backend_demo.pojo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@ApiModel(description="user object")
@Data
public class User {

    private Long id;
    @NotNull(message = "user name should not be null")
    private String name;
    @NotNull(message = "user age should not be null")
    private Integer age;
    @NotNull
    @Email(message = "vxcvfd")
    private String email;
}
