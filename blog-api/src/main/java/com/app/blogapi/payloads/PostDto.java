package com.app.blogapi.payloads;

import java.util.Date;

import com.app.blogapi.entities.Category;
import com.app.blogapi.entities.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {
    
    private String title;
    private String content;

     private String imageName;
    private Date addedDate;

    private UserDto user;
    private CategoryDto category;
}
