package com.app.blogapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.blogapi.entities.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    
}
