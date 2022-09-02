package com.example.java_backend_demo.Vo;

import com.example.java_backend_demo.Model.UserPersonalInfo;

import java.util.ArrayList;
import java.util.Collections;

public class AppUserVo {
    private Integer id;
    private String userName;
    private String emailAddress;
    private String password;
    private String name;
    ArrayList<String> authorities;

    public AppUserVo(UserPersonalInfo userPersonalInfo){
        this.id = userPersonalInfo.getId();
        this.emailAddress = userPersonalInfo.getEmail();
        this.userName = userPersonalInfo.getName();
        this.password = userPersonalInfo.getPassword();
        this.name = userPersonalInfo.getName();
        this.userName = userPersonalInfo.getUserName();
        this.authorities = new ArrayList<String>(Collections.singleton(userPersonalInfo.getUserRole()));

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    public String getUserName(){return this.userName;}
    public void setUserName(String userName){ this.userName = userName; }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(ArrayList<String> authorities) {
        this.authorities = authorities;
    }


}
