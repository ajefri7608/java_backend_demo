package com.example.java_backend_demo.exception;


import com.example.java_backend_demo.Model.ApiMsg;
import lombok.Data;

@Data

public class GeneralException extends Exception{
    ApiMsg apiMsg;
    public GeneralException(ApiMsg apiMsg){
        super("Error massage: " + apiMsg.toString());
        this.apiMsg = apiMsg;

    }
}
