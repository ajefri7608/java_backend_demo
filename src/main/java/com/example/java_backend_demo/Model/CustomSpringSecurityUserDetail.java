package com.example.java_backend_demo.Model;

import com.example.java_backend_demo.Vo.AppUserVo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;
import java.util.stream.Collectors;

public class CustomSpringSecurityUserDetail implements UserDetails {
    AppUserVo appUser;
    public CustomSpringSecurityUserDetail(AppUserVo appUser){
        this.appUser = appUser;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return appUser.getAuthorities().stream()
                .map(auth -> new SimpleGrantedAuthority(auth))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        //TODO
        return new BCryptPasswordEncoder().encode(appUser.getPassword());
    }

    @Override
    public String getUsername() {
        return appUser.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
