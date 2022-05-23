package com.example.java_backend_demo.exception;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class ExceptionHandle extends Exception{
    public ExceptionHandle(String errorMessage){
        super("Error massage: " + errorMessage);
    }


}
