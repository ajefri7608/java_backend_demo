package com.example.java_backend_demo.service;

import com.example.java_backend_demo.exception.ExceptionHandle;
import com.example.java_backend_demo.pojo.ApiMsg;
import com.example.java_backend_demo.pojo.GeneralResponse;
import com.example.java_backend_demo.util.LocalApiMsg;
import io.swagger.annotations.Api;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseService <T> {

    @Autowired
    protected ApiMsgService apiMsgService;
    protected Boolean validate(T req) throws ExceptionHandle {
        return true;
    }


    public GeneralResponse start(T request) throws ExceptionHandle{
        if(!validate(request)){
            throw new ExceptionHandle(new ApiMsg(LocalApiMsg.Success));
        }else{
            return process(request);
        }
    };
    protected abstract GeneralResponse process(T request) throws ExceptionHandle;
    protected GeneralResponse returnRsp(Object data, ApiMsg apiMsg){
        return new GeneralResponse(apiMsgService.getAppMsg(apiMsg));
    }
    protected GeneralResponse returnRsp(){
        return new GeneralResponse(LocalApiMsg.Success);
    }
    protected GeneralResponse returnRsp(ApiMsg apiMsg){
        return new GeneralResponse(apiMsg);
    }
}
