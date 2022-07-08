package com.example.java_backend_demo.pojo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description="user object")
@Entity
@Table(name = "user_personal_info")
public class UserPersonalInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private String id;

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
    @Column(name = "AGE")
    private Integer age;
    @Column(name = "IMAGE")
    private Integer image;

    public UserPersonalInfo(String userName, String password){
        this.userName = userName;
        this.password = password;
    }



}
