package com.example.java_backend_demo.Pojo;

import lombok.Data;

import javax.persistence.*;

@Data

@Table(name = "API_MESSAGE")
@Entity
public class ApiMsg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="RSP_CODE")
    private Integer rspCode;
    @Column(name ="RSP_TITLE")
    private String rspTitle;
    @Column(name ="RSP_MSG")
    private String rspMsg;


    public ApiMsg(Integer rspCode, String rspTitle, String rspMsg) {
        this.rspCode = rspCode;
        this.rspTitle = rspTitle;
        this.rspMsg = rspMsg;
    }

    public ApiMsg() {
    }
}
