package com.app.blogapi.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.blogapi.payloads.CategoryDto;

public interface CategoryService {
    
    ResponseEntity<List<CategoryDto>> getAllCategory();
    ResponseEntity<CategoryDto> getCategoryById();
    
    ResponseEntity<CategoryDto> createCategory(CategoryDto categoryDto);
    ResponseEntity<CategoryDto> updateCategory(int id, CategoryDto categoryDto);

    ResponseEntity<String> deleteCategory(int id);
}
