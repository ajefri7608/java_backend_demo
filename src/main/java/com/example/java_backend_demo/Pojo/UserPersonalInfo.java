package com.example.java_backend_demo.Pojo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description="user object")
@Entity
@Table(name = "USER_PERSONAL_INFO")
public class UserPersonalInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @NotEmpty
    @Column(name = "USER_NAME")
    private String userName;
    @Column(name = "EMAIL_ADDRESS")
    private String email;
    @NotEmpty
    @Column(name = "PASSWORD")
    private String password;
    @NotEmpty
    @Column(name = "NAME")
    private String name;
    @Column(name = "USER_ROLE")
    private String userRole;
    @Column(name = "USER_ACCESS_TOKEN")
    private String userAccessToken;
    @Column(name = "TOKEN_EXPIRE_AT")
    private String tokenExpireAt;
    @Column(name = "IMAGE")
    private Integer image;
    @Column(name = "LOGIN_PROVIDER")
    private String provider;



    public UserPersonalInfo(String userName, String password){
        this.userName = userName;
        this.password = password;
    }



}
