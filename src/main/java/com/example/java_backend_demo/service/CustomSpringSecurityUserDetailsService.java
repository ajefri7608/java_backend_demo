package com.example.java_backend_demo.service;

import com.example.java_backend_demo.Pojo.CustomSpringSecurityUserDetail;
import com.example.java_backend_demo.Pojo.UserPersonalInfo;
import com.example.java_backend_demo.Vo.AppUserVo;
import com.example.java_backend_demo.exception.GeneralException;
import com.example.java_backend_demo.repository.UserRepository;
import com.example.java_backend_demo.util.LocalApiMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomSpringSecurityUserDetailsService  implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ArrayList<UserPersonalInfo> users = repository.findByUserName(username);
        if(users.size() > 0 ){
            AppUserVo appUserVo = new AppUserVo(users.get(0));

            return new CustomSpringSecurityUserDetail(appUserVo);
        }else{
            throw new UsernameNotFoundException("User not found");
        }


    }



}
