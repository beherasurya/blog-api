package com.app.blogapi.services.serviceimplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.blogapi.entities.User;
import com.app.blogapi.exceptions.ResourceNotFoundException;
import com.app.blogapi.payloads.UserDto;
import com.app.blogapi.repositories.UserRepository;
import com.app.blogapi.services.UserService;

@Service
public class UserServiceImplementation implements UserService{


    @Autowired
    private UserRepository userRepository ;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {


        User user= userDtoToUser(userDto);
        User savedUser= userRepository.save(user);
        
      return  userToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(int id) {

        if (userRepository.findById(id).isEmpty()) {

            throw new ResourceNotFoundException("Resource Not Found to fetch the User",id);
            
        }

        User userById= userRepository.findById(id).get();
        return userToUserDto(userById);
    }

    @Override
    public List<UserDto> getAllUsers() {
      
        if (userRepository.findAll().isEmpty()) {

            throw new ResourceNotFoundException("Resource Not Found to fetch user data");
            
        }

        List<User> users= userRepository.findAll();
        List<UserDto> userDtos= users.stream().map(singleUser->userToUserDto(singleUser)).collect(Collectors.toList());

        return userDtos;

    }

    @Override
    public UserDto updateUser(UserDto userDto, int id) {
        
         if (userRepository.findById(id).isEmpty()) {

            throw new ResourceNotFoundException("Resource Not Found to update User Details",id);
            
        }
        
        User  updateUser = userDtoToUser(userDto);
        updateUser.setId(id);

        updateUser= userRepository.save(updateUser);
        return userToUserDto(updateUser);
    }

    @Override
    public String deleteUser(int id) {

         if (userRepository.findById(id).isEmpty()) {

            throw new ResourceNotFoundException("Resource Not Found to Delete User",id);
            
            }

            userRepository.deleteById(id);
            return "User Details Deleted from the Database";
            

    }

    private User userDtoToUser(UserDto userDto){

        User user = modelMapper.map(userDto, User.class);
       /* user.setName(userDto.getName());

        user.setEmail(userDto.getEmail());
        user.setAbout(userDto.getAbout());

        user.setPassword(userDto.getPassword());
        user.setId(userDto.getId());*/
        return user;
    }
    private UserDto userToUserDto(User user){

        UserDto userDto =modelMapper.map(user, UserDto.class);
        
        return userDto;
    }
    
}
