package com.example.java_backend_demo.controller;

import com.example.java_backend_demo.Oauth.CustomOAuth2User;
import com.example.java_backend_demo.exception.GeneralException;
import com.example.java_backend_demo.pojo.GeneralResponse;
import com.example.java_backend_demo.pojo.UserPersonalInfo;

import com.example.java_backend_demo.service.UserCreateService;
import com.example.java_backend_demo.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spi.service.contexts.SecurityContextBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;
import java.util.*;


@RestController
@RequestMapping(value = "/users")
public class UserController extends BaseController{

    @Autowired
    UserCreateService userCreateService;
    @Autowired
    UserLoginService userLoginService;
    static Map<String, UserPersonalInfo> users = Collections.synchronizedMap(new HashMap<>());

    @GetMapping("/")
    public List<UserPersonalInfo> getUserList() {
        List<UserPersonalInfo> r = new ArrayList<>(users.values());
        return r;
    }

    @PostMapping("/register")
    public GeneralResponse createUser(@Valid @RequestBody UserPersonalInfo user) throws GeneralException {
        return userCreateService.start(user);
    }

    @GetMapping("/login")
    public GeneralResponse login(@Valid @RequestBody UserPersonalInfo user) throws GeneralException {
        return userCreateService.start(user);
    }

    @GetMapping("/oauthLoginRedirect")
    public GeneralResponse loginFacebook() throws GeneralException, IOException {

        return userLoginService.processOAuthPostLogin();
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        users.remove(id);
        return "success";
    }

}