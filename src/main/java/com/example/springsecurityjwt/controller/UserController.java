package com.example.springsecurityjwt.controller;

import com.example.springsecurityjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/")
    private String homePage(){
        return "hi";
    }
    @GetMapping("/login")
    private String login(){
        return "login";
    }
    @GetMapping("/register")
    private String register(){
        return "register";
    }
}
