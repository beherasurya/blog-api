package com.app.blogapi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.app.blogapi.payloads.UserDto;
import com.app.blogapi.services.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
    
    @Autowired
    private UserService userService;


    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> getAllUsers(){

        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getUserById(@PathVariable int id){

        return userService.getUserById(id);

    }

    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public UserDto updateUser(@Valid @PathVariable int id, @RequestBody UserDto userDto){

        return userService.updateUser(userDto, id);

    }
    
    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto createUser(@Valid @RequestBody UserDto userDto){
        return userService.createUser(userDto);
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteUser(@PathVariable int id){

       return userService.deleteUser(id);
    }

}
