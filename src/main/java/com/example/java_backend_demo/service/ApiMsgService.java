package com.example.java_backend_demo.service;

import com.example.java_backend_demo.pojo.ApiMsg;
import com.example.java_backend_demo.repository.ApiMsgRepository;
import org.springframework.stereotype.Component;

@Component
public class ApiMsgService {
    ApiMsgRepository apiMsgRepository;
    public ApiMsg getAppMsg(ApiMsg apiMsg){
        try{
            return apiMsgRepository.findByRspCode(apiMsg.getRspCode());
        }catch (Exception e){
            return apiMsg;
        }

    }
}
