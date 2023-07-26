package com.app.blogapi.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.app.blogapi.payloads.PostDto;
import com.app.blogapi.services.PostService;

@RestController
@RequestMapping("/api")
public class PostController {
    
    @Autowired
    PostService postService;

    @PostMapping("/user/{userId}/category/{categoryId}/post")
    public ResponseEntity<PostDto> makePost( @Valid @RequestBody PostDto postDto, @PathVariable int userId, @PathVariable int categoryId){

        postDto =postService.createPost(postDto, userId, categoryId);
        return new ResponseEntity<PostDto>(postDto, HttpStatus.CREATED) ;
    }

}
