package com.app.blogapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.blogapi.payloads.UserDto;
import com.app.blogapi.services.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
    
    @Autowired
    UserService userService;


    @GetMapping("/users")
    
    public List<UserDto> getAllUsers(){

        return userService.getAllUsers();
    }

}
