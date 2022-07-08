package com.example.java_backend_demo.controller;

import com.example.java_backend_demo.exception.GeneralException;
import com.example.java_backend_demo.pojo.GeneralResponse;
import com.example.java_backend_demo.pojo.UserPersonalInfo;

import com.example.java_backend_demo.service.UserCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;


@RestController
@RequestMapping(value = "/users")
public class UserController extends BaseController{

    @Autowired
    UserCreateService userCreateService;
    static Map<String, UserPersonalInfo> users = Collections.synchronizedMap(new HashMap<>());

    @GetMapping("/")
    public List<UserPersonalInfo> getUserList() {
        List<UserPersonalInfo> r = new ArrayList<>(users.values());
        return r;
    }

    @PostMapping("/")
    public GeneralResponse createUser(@Valid @RequestBody UserPersonalInfo user) throws GeneralException {
        return userCreateService.start(user);
    }

    @GetMapping("/{id}")
    public UserPersonalInfo getUser(@PathVariable Long id) {
        return users.get(id);
    }

    @PutMapping("/{id}")
    public String putUser(@PathVariable String id, @RequestBody UserPersonalInfo user) {
        UserPersonalInfo u = users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id, u);
        return "success";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        users.remove(id);
        return "success";
    }

}