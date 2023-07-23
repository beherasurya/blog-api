package com.app.blogapi.services.serviceimplementation;

import java.util.List;
import java.util.stream.Collectors;

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


        User user= userDtoToUser(userDto);
        User savedUser= userRepository.save(user);
        
      return  userToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(int id) {

        User userById= userRepository.findById(id).get();
        return userToUserDto(userById);
    }

    @Override
    public List<UserDto> getAllUsers() {
      
        List<User> users= userRepository.findAll();
        List<UserDto> userDtos= users.stream().map(singleUser->userToUserDto(singleUser)).collect(Collectors.toList());

        return userDtos;

    }

    @Override
    public UserDto updateUser(UserDto userDto, int id) {
        
        
        User  updateUser = userDtoToUser(userDto);
        updateUser.setId(id);

        updateUser= userRepository.save(updateUser);
        return userToUserDto(updateUser);
    }

    @Override
    public void deleteUser(int id) {

            userRepository.deleteById(id);

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
