package com.example.java_backend_demo.service;

import com.example.java_backend_demo.exception.GeneralException;
import com.example.java_backend_demo.pojo.ApiMsg;
import com.example.java_backend_demo.pojo.GeneralResponse;
import com.example.java_backend_demo.util.LocalApiMsg;
import io.swagger.annotations.Api;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseService <T> {

    @Autowired
    protected ApiMsgService apiMsgService;
    protected Boolean validate(T req) throws GeneralException {
        return true;
    }


    public GeneralResponse start(T request) throws GeneralException{
        if(!validate(request)){
            throw new GeneralException(LocalApiMsg.DataNotValid);
        }else{
            return process(request);
        }
    };
    protected abstract GeneralResponse process(T request) throws GeneralException;
    protected GeneralResponse returnRsp(Object data, ApiMsg apiMsg){
        return new GeneralResponse(apiMsgService.getAppMsg(apiMsg));
    }
    protected GeneralResponse returnRsp(){
        return new GeneralResponse(LocalApiMsg.Success);
    }
    protected GeneralResponse returnRsp(ApiMsg apiMsg){
        return new GeneralResponse(apiMsg);
    }
    protected GeneralResponse returnRsp(ApiMsg apiMsg, Object data){
        return new GeneralResponse(apiMsg, data);
    }
}
