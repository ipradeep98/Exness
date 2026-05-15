package com.my.exness.controller;

import com.my.exness.model.Users;
import com.my.exness.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    private Users register(@RequestBody Users user){
        return userService.register(user);
    }

    @PostMapping("/login")
    private String login(@RequestBody Users user){
        return userService.verify(user);
    }
}
