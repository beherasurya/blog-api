package com.app.blogapi.services.serviceimplementation;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.blogapi.entities.Category;
import com.app.blogapi.entities.Post;
import com.app.blogapi.entities.User;
import com.app.blogapi.exceptions.ResourceNotFoundException;
import com.app.blogapi.payloads.ApiResponse;
import com.app.blogapi.payloads.PostDto;
import com.app.blogapi.repositories.CategoryRepository;
import com.app.blogapi.repositories.PostRepository;
import com.app.blogapi.repositories.UserRepository;
import com.app.blogapi.services.PostService;

@Service
public class PostServiceIplementation implements PostService  {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PostDto createPost(PostDto postDto, int userId, int categoryId) {    

        Post post= modelMapper.map(postDto, Post.class);
        User user = userRepository.findById(userId)
        .orElseThrow(()-> new ResourceNotFoundException("User id not Found",userId));

        Category category = categoryRepository.findById(categoryId)
            .orElseThrow(()->new ResourceNotFoundException("Category Id not found", categoryId));
        
        post.setImageName("default.png");
        post.setAddedDate(new Date());

        post.setCategory(category);
        post.setUser(user);

        post = postRepository.save(post);
        postDto = modelMapper.map(post, PostDto.class);

        return postDto;

    }

    @Override
    public List<PostDto> getAllPost() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllPost'");
    }

  
    @Override
    public PostDto updatePost(int id, PostDto postDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePost'");
    }

    @Override
    public ApiResponse deletePost(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletePost'");
    }

    @Override
    public PostDto getPostById(int postId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPostById'");
    }

    @Override
    public List<PostDto> getPostsByUser(int userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPostsByUser'");
    }

    @Override
    public List<PostDto> getPostsByCategory(int categoryId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPostsByCategory'");
    }

    @Override
    public List<PostDto> searchPost(String keyword) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchPost'");
    }
    
}
