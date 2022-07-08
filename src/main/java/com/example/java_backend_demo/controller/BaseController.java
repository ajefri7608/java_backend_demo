package com.example.java_backend_demo.controller;

import com.example.java_backend_demo.exception.GeneralException;
import com.example.java_backend_demo.pojo.ApiMsg;
import com.example.java_backend_demo.pojo.GeneralResponse;
import com.example.java_backend_demo.service.ApiMsgService;
import com.example.java_backend_demo.util.LocalApiMsg;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

public abstract class BaseController {
    @Autowired
    ApiMsgService apiMsgService;
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public GeneralResponse handleException(Exception e){
        return new GeneralResponse(LocalApiMsg.SystemError);
    }

    @ExceptionHandler(GeneralException.class)
    @ResponseBody
    public GeneralResponse handleException(GeneralException e){
        ApiMsg apiMsg = apiMsgService.getAppMsg(e.getApiMsg());
        if(apiMsg.getRspCode() == null){
            apiMsg = e.getApiMsg();
        }

        return new GeneralResponse(apiMsg);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public GeneralResponse handleException(MethodArgumentNotValidException e){
        if(e.getBindingResult().getFieldError() != null){
            System.out.println(e.getBindingResult().getFieldError().getField());
        }

        return new GeneralResponse(LocalApiMsg.DataNotValid);
    }



}
