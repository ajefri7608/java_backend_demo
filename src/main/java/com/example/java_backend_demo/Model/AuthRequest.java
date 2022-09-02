package com.example.java_backend_demo.Model;

import javax.validation.constraints.NotBlank;

public class AuthRequest {
    @NotBlank
    private String userName;

    @NotBlank
    private String password;

    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AuthRequest(String userName, String password){
        this.userName = userName;
        this.password = password;

    }
}
