package com.example.java_backend_demo.exception;


import com.example.java_backend_demo.pojo.ApiMsg;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data

public class ExceptionHandle extends Exception{
    public ExceptionHandle(ApiMsg apiMsg){
        super("Error massage: " + apiMsg.toString());
    }


}
