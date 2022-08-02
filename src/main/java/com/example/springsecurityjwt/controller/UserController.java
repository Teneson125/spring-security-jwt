package com.example.springsecurityjwt.controller;

import com.example.springsecurityjwt.entity.AuthRequest;
import com.example.springsecurityjwt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;


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

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest)  {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            //throw new Exception(ex);
            return "invalid username or password";
        }
        return jwtUtil.generateToken(authRequest.getUserName());
    }
}
