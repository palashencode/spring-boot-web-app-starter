package com.java.spring.starterweb.service;

import com.java.spring.starterweb.model.UserDetail;
import com.java.spring.starterweb.model.UserDetail.ROLE;

import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    public UserDetail getUser(String user, String password){
        if (user.equalsIgnoreCase("jack") && password.equalsIgnoreCase("manage")) {
            return new UserDetail(user,UserDetail.ROLE.USER);
        }
        if (user.equalsIgnoreCase("jane") && password.equalsIgnoreCase("manage")) {
            return new UserDetail(user,UserDetail.ROLE.ADMIN);
        }
        return null;
    }
}   
