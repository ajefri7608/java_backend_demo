package com.example.java_backend_demo.controller;

import com.example.java_backend_demo.exception.GeneralException;
import com.example.java_backend_demo.Pojo.AuthRequest;
import com.example.java_backend_demo.Pojo.GeneralResponse;
import com.example.java_backend_demo.Pojo.UserPersonalInfo;

import com.example.java_backend_demo.service.JWTService;
import com.example.java_backend_demo.service.UserCreateService;
import com.example.java_backend_demo.service.UserLoginService;
import com.example.java_backend_demo.util.LocalApiMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.*;


@RestController
@RequestMapping(value = "/users")
public class UserController extends BaseController{

    @Autowired
    UserCreateService userCreateService;
    @Autowired
    JWTService jwtService;
    @Autowired
    UserLoginService userLoginService;
    static Map<String, UserPersonalInfo> users = Collections.synchronizedMap(new HashMap<>());

    @PostMapping("/register")
    public GeneralResponse createUser(@Valid @RequestBody UserPersonalInfo user) throws GeneralException {
        return userCreateService.start(user);
    }

    @PostMapping("/login")
    public GeneralResponse login(@Valid @RequestBody UserPersonalInfo user) throws GeneralException {
        return userLoginService.start(user);
    }

    @GetMapping("/oauthLoginRedirect")
    public GeneralResponse loginFacebook() throws GeneralException, IOException {

        return userLoginService.processOAuthPostLogin();
    }
    @PostMapping("/genToken")
    public GeneralResponse generateToken(@Valid @RequestBody AuthRequest request) {
        String token = jwtService.generateToken(request);
        Map<String, String> response = Collections.singletonMap("token", token);

        return new GeneralResponse(LocalApiMsg.Success, response);
    }


}