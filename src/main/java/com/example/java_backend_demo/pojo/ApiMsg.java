package com.example.java_backend_demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

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

    public ApiMsg(ApiMsg apiMsg) {
    }
}
