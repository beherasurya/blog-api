package com.app.blogapi.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name ="post")
@Getter
@Setter
@NoArgsConstructor
public class Post {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;

    @NotBlank
    private String title;

    @Size( message = "Minimun 10 characters required")
    private String content;

    private String imageName;
    private Date addedDate;

    @ManyToOne
    private User user;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
