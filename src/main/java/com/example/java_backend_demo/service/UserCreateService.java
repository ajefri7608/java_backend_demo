package com.example.java_backend_demo.service;

import com.example.java_backend_demo.exception.GeneralException;
import com.example.java_backend_demo.Pojo.GeneralResponse;
import com.example.java_backend_demo.Pojo.UserPersonalInfo;
import com.example.java_backend_demo.repository.UserRepository;
import com.example.java_backend_demo.util.LocalApiMsg;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserCreateService extends BaseService<UserPersonalInfo>{

    @Autowired
    UserRepository repository;
    @Override
    protected GeneralResponse process(UserPersonalInfo request) throws GeneralException {
        if(crossCheckIsUserExist(request))  {
            return returnRsp(LocalApiMsg.UserAlreadyExist);
        }
        repository.createUser(request);
        return returnRsp(LocalApiMsg.Success, request);
    }
    private Boolean crossCheckIsUserExist(UserPersonalInfo request){
        return repository.findByUserName(request.getUserName()) != null || repository.findByUserName(request.getEmail()) != null
                || repository.findByEmail(request.getEmail()) != null || repository.findByEmail(request.getUserName()) != null;
    }

    @Override
    protected Boolean validate(UserPersonalInfo req) throws GeneralException {
        if(StringUtils.isBlank(req.getPassword()) || StringUtils.isBlank(req.getName()) || StringUtils.isBlank(req.getUserName())){
            throw new GeneralException(LocalApiMsg.SomeFieldEmpty);
        }
        return super.validate(req);
    }
}
