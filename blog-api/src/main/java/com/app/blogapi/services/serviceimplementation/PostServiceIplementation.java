package com.app.blogapi.services.serviceimplementation;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
        
        List<Post> post= postRepository.findAll();
        List<PostDto> postDto = post.stream()
        .map((element)->modelMapper.map(element, PostDto.class))
        .collect(Collectors.toList());

        return postDto;
    }

  
    @Override
    public PostDto updatePost(int id, PostDto postDto) {
        Post updatePost = postRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Post Not Found", id));
        
        updatePost.setPostId(id);
        updatePost.setTitle(postDto.getTitle());

        updatePost.setContent(postDto.getContent());
        updatePost = postRepository.save(updatePost);

        return modelMapper.map(updatePost, PostDto.class);

    }

    @Override
    public ApiResponse deletePost(int id) {
        
        
             postRepository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Post you are trying to Delete Not Found", id));

        return new ApiResponse("Post Deleted Successfully", true);
    }

    @Override
    public PostDto getPostById(int postId) {
        
        Post post = postRepository.findById(postId)
            .orElseThrow(()->new ResourceNotFoundException("Post Not Found", postId));

        PostDto postDto = modelMapper.map(post, PostDto.class);
        return postDto;
    }

    @Override
    public List<PostDto> getPostsByUserId(int userId) {
        
        User user = userRepository.findById(userId)
                    .orElseThrow(()->new ResourceNotFoundException("User Not Found", userId));

        if(postRepository.findPostByUser(user).isEmpty()){
            throw new ResourceNotFoundException("Post Not Found", userId);
        }

         List<Post> userPosts = postRepository.findPostByUser(user);            
        List<PostDto> postDtos = userPosts.stream()
        .map((postElement)->modelMapper.map(postElement, PostDto.class))
        .collect(Collectors.toList());

        return postDtos;
   }

    @Override
    public List<PostDto> getPostsByCategory(int categoryId) {
        Category category = categoryRepository.findById(categoryId)
                    .orElseThrow(()->new ResourceNotFoundException("Category Not Found", categoryId));
        
        if(postRepository.findPostByCategory(category).isEmpty()){
            throw new ResourceNotFoundException("Post Not Found", categoryId);
        }

        List<Post> postsByCategoryId = postRepository.findPostByCategory(category);
        List<PostDto> postDtosByCategoryId = postsByCategoryId.stream()
                    .map((postElement)->modelMapper.map(postElement, PostDto.class))
                    .collect(Collectors.toList());
        
        return postDtosByCategoryId;
    }

    @Override
    public List<PostDto> searchPost(String keyword) {
        
        if(postRepository.findByTitle(keyword).isEmpty()){
            throw new ResourceNotFoundException("Post Not Found");
        }

        List<Post> posts= postRepository.findByTitle(keyword);
        List<PostDto> postDtos = posts.stream()
            .map((postElement)->modelMapper.map(postElement, PostDto.class))
            .collect(Collectors.toList());

        return postDtos;

    }
    
}
