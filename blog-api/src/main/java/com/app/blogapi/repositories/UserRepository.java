package com.app.blogapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.blogapi.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    
    
}
