package com.app.blogapi.services;

import java.util.List;

import com.app.blogapi.payloads.ApiResponse;
import com.app.blogapi.payloads.PostDto;

public interface PostService {
    
   PostDto createPost(PostDto postDto, int userId, int categoryId);
   List<PostDto> getAllPost();

   PostDto getPostById(int postId);
   PostDto updatePost(int id, PostDto postDto);

   ApiResponse deletePost(int id);
   List<PostDto> getPostsByUser(int userId);

   List<PostDto> getPostsByCategory(int categoryId);
   List<PostDto> searchPost(String keyword);
}
