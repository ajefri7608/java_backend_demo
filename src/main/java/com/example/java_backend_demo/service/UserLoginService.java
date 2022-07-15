package com.example.java_backend_demo.service;

import com.example.java_backend_demo.Oauth.CustomOAuth2User;
import com.example.java_backend_demo.exception.GeneralException;
import com.example.java_backend_demo.Pojo.GeneralResponse;
import com.example.java_backend_demo.Pojo.UserPersonalInfo;
import com.example.java_backend_demo.repository.UserRepository;
import com.example.java_backend_demo.util.LocalApiMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class UserLoginService extends BaseService<UserPersonalInfo>{
    @Autowired
    UserRepository repository;
    @Override
    protected GeneralResponse process(UserPersonalInfo request) throws GeneralException {
        ArrayList<UserPersonalInfo> userList = repository.findByUserName(request.getUserName());
        if(userList.size() > 0){
            return returnRsp(LocalApiMsg.UserAlreadyExist);
        }
        return returnRsp(LocalApiMsg.UserNotFound);
    }
    public GeneralResponse processOAuthPostLogin() throws GeneralException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null){
            throw new GeneralException(LocalApiMsg.SessionExpired);
        }
        CustomOAuth2User oauthUser = (CustomOAuth2User) authentication.getPrincipal();

        ArrayList<UserPersonalInfo> userList = repository.findByUserName("fb" + oauthUser.getId());

        if(userList.size() > 0){
            return returnRsp(LocalApiMsg.Success, userList.get(0));
        }else{
            UserPersonalInfo newUser = new UserPersonalInfo();
            newUser.setUserName("fb" + oauthUser.getId());
            newUser.setPassword("pwtest");
            newUser.setEmail(oauthUser.getEmail());
            newUser.setUserRole("Employee");
            newUser.setImage(null);
            newUser.setName(oauthUser.getName());
            newUser.setProvider("FaceBook");
            repository.save(newUser);
            return returnRsp(LocalApiMsg.Success, newUser);
        }
    }

}
