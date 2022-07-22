package com.example.java_backend_demo.service;

import com.example.java_backend_demo.Oauth.CustomOAuth2User;
import com.example.java_backend_demo.Pojo.AuthRequest;
import com.example.java_backend_demo.exception.GeneralException;
import com.example.java_backend_demo.Pojo.GeneralResponse;
import com.example.java_backend_demo.Pojo.UserPersonalInfo;
import com.example.java_backend_demo.repository.UserRepository;
import com.example.java_backend_demo.util.LocalApiMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class UserLoginService extends BaseService<UserPersonalInfo>{
    @Autowired
    UserRepository repository;
    @Lazy
    @Autowired
    JWTService jwtService;

    @Override
    protected GeneralResponse process(UserPersonalInfo request) throws GeneralException {
        ArrayList<UserPersonalInfo> userListByEmail = repository.findByUserName(request.getUserName());
        ArrayList<UserPersonalInfo> userListByUserName = repository.findByUserName(request.getUserName());
        if(userListByEmail.size() > 0 || userListByUserName.size() > 0){
            UserPersonalInfo user = userListByEmail.size() > 0 ? userListByEmail.get(0) : userListByUserName.get(0);
            if(user.getPassword().equals(request.getPassword())){
                String token = jwtService.generateToken(new AuthRequest(user.getUserName(), user.getPassword()));
                user.setUserAccessToken(token);
                return returnRsp(LocalApiMsg.Success, user);
            }else{
                return returnRsp(LocalApiMsg.UserInfoNotValid);
            }

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
        UserPersonalInfo newUser = new UserPersonalInfo();
        if(userList.size() > 0){
            newUser = userList.get(0);
        }else{

            newUser.setUserName("fb" + oauthUser.getId());
            newUser.setPassword("pwtest");
            newUser.setEmail(oauthUser.getEmail());
            newUser.setUserRole("Employee");
            newUser.setImage(null);
            newUser.setName(oauthUser.getName());
            newUser.setProvider("FaceBook");
            repository.save(newUser);

        }
        String token = jwtService.generateToken(new AuthRequest(newUser.getUserName(), newUser.getPassword()));
        newUser.setUserAccessToken(token);
        return returnRsp(LocalApiMsg.Success, newUser);
    }

}
