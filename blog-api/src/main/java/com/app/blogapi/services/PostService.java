package com.app.blogapi.services;

import java.util.List;

import com.app.blogapi.payloads.ApiResponse;
import com.app.blogapi.payloads.PostDto;
import com.app.blogapi.payloads.PostResponse;

public interface PostService {
    
   PostDto createPost(PostDto postDto, int userId, int categoryId);
   PostResponse getAllPost(int pageNumber, int pageSize);

   PostDto getPostById(int postId);
   PostDto updatePost(int id, PostDto postDto);

   ApiResponse deletePost(int id);
   List<PostDto> getPostsByUserId(int userId);

   // PostResponse getPostsByUserId(int userId, int pageNumber, int pageSize);
   // PostResponse getPostsByCategory(int categoryId, int pageNumber, int pageSize);

   List<PostDto> getPostsByCategory(int categoryId);
   List<PostDto> searchPost(String keyword);
}
