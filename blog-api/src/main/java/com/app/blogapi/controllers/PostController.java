package com.app.blogapi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.blogapi.payloads.ApiResponse;
import com.app.blogapi.payloads.PostDto;
import com.app.blogapi.payloads.PostResponse;
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

    @GetMapping("/post")
    public ResponseEntity<PostResponse>  getAllpost
    (@RequestParam(defaultValue = "0" ,required = false) int pageNumber,
    @RequestParam(defaultValue = "5", required = false) int pageSize){

        PostResponse postResponse= postService.getAllPost(pageNumber, pageSize);
        return new ResponseEntity<PostResponse>(postResponse, HttpStatus.OK);
    }


    @GetMapping("/post/user/{userId}")
    public ResponseEntity<List<PostDto>> getPostsByUserId(@PathVariable int userId){

        List<PostDto> postsByUser = postService.getPostsByUserId(userId);
        return new ResponseEntity<List<PostDto>>(postsByUser, HttpStatus.OK);
    }

    @GetMapping("/post/category/{categoryId}")
    public ResponseEntity<List<PostDto>> getPostByCategoryId(@PathVariable int categoryId){

        List<PostDto> postsByCategoryId = postService.getPostsByCategory(categoryId);
        return new ResponseEntity<List<PostDto>>(postsByCategoryId, HttpStatus.OK);
    }

    @PutMapping("/post/{id}")
    public ResponseEntity<PostDto> updatePost(@PathVariable int id,@RequestBody PostDto postDto){

        PostDto updatedPost = postService.updatePost(id, postDto);
        return new ResponseEntity<PostDto>(updatedPost, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/post/{id}")
    public ResponseEntity<ApiResponse> deletePost(@PathVariable int id){

        ApiResponse apiResponse = postService.deletePost(id);
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/post/keyword/{keyword}")
    public ResponseEntity<List<PostDto>> searchPost(@PathVariable String keyword){
        List<PostDto> postDtos = postService.searchPost(keyword);
        return new ResponseEntity<List<PostDto>>(postDtos, HttpStatus.OK);
    }
}
