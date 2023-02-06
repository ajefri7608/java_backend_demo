package com.example.java_backend_demo.Model;

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

