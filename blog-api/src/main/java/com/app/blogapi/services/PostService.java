package com.app.blogapi.services;

import java.util.List;

import com.app.blogapi.payloads.ApiResponse;
import com.app.blogapi.payloads.PostDto;

public interface PostService {
    
   PostDto createPost(PostDto postDto);
   List<PostDto> getAllPost();

   PostDto getPostById();
   PostDto updatePost(int id, PostDto postDto);

   ApiResponse deletePost(int id);
}
