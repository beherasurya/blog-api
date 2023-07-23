package com.app.blogapi.services.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.blogapi.entities.User;
import com.app.blogapi.payloads.UserDto;
import com.app.blogapi.repositories.UserRepository;
import com.app.blogapi.services.UserService;

public class UserServiceImplementation implements UserService{


    @Autowired
    UserRepository userRepository ;

    @Override
    public UserDto createUser(UserDto userDto) {
        // TODO Auto-generated method stub

        User user= userDtoToUser(userDto);
        User savedUser= userRepository.save(user);
        
      return  userToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserById'");
    }

    @Override
    public List<UserDto> getAllUsers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllUsers'");
    }

    @Override
    public UserDto updateUser(UserDto userDto, int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
    }

    @Override
    public UserDto deleteUser(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
    }

    private User userDtoToUser(UserDto userDto){

        User user = new User();
        user.setName(userDto.getName());

        user.setEmail(userDto.getEmail());
        user.setAbout(userDto.getAbout());

        user.setPassword(userDto.getPassword());
        return user;
    }
    private UserDto userToUserDto(User user){

        UserDto userDto =new UserDto();
        userDto.setName(user.getName());

        userDto.setEmail(user.getEmail());
        userDto.setAbout(user.getAbout());

        userDto.setPassword(user.getPassword());
        return userDto;
    }
    
}
