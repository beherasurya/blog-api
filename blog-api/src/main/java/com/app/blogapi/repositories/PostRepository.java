package com.app.blogapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.blogapi.entities.Category;
import com.app.blogapi.entities.Post;
import com.app.blogapi.entities.User;

public interface PostRepository extends JpaRepository<Post,Integer> {
    
    List<Post> getAllPostByUser(User user);
    List<Post> getAllPostByCategory(Category category);
}