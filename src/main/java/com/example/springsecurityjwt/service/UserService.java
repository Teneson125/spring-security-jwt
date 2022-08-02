package com.example.springsecurityjwt.service;

import com.example.springsecurityjwt.entity.User;
import com.example.springsecurityjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @PostConstruct
    public void initUsers() {
        List<User> users = Stream.of(
                new User("manoj","passowrd"),
                new User("manoj2","passowrd"),
                new User("manoj3","passowrd")
        ).collect(Collectors.toList());
        repository.saveAll(users);
    }
}
