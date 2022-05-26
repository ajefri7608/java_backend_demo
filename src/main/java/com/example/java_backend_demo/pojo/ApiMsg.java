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
    @Column(name ="RspCode")
    private String rspCode;
    @Column(name ="RspTitle")
    private String rspTitle;
    @Column(name ="RspMsg")
    private String rspMsg;

}
