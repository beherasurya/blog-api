package com.app.blogapi.services;

import java.util.List;

import com.app.blogapi.payloads.UserDto;

public interface UserService {
    
    UserDto createUser(UserDto userDto);
    UserDto getUserById(int id);

    List<UserDto> getAllUsers();
    UserDto updateUser(UserDto userDto, int id);

    String deleteUser(int id);
}
