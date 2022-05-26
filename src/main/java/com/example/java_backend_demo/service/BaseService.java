package com.example.java_backend_demo.service;

import com.example.java_backend_demo.exception.ExceptionHandle;
import com.example.java_backend_demo.pojo.ApiMsg;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseService <T> {

    @Autowired
    protected ApiMsgService apiMsgService;
    protected Boolean validate(T req) throws ExceptionHandle {
        return null;
    }
    //abstract ApiMsg process(T request);
    protected ApiMsg returnRsp(ApiMsg apiMsg){
        return apiMsgService.getAppMsg(apiMsg);
    }
}
