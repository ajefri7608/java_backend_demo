package com.example.java_backend_demo.Pojo;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Arrays;

public enum UserAuthority {
    ADMIN, EMPLOYEE;

//    @JsonCreator
//    public UserAuthority fromString(String key) {
//        return Arrays.stream(values())
//                .filter(value -> value.name().equalsIgnoreCase(key))
//                .findFirst()
//                .orElse(null);
//    }
}

