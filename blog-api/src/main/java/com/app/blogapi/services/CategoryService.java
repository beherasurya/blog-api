package com.app.blogapi.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.blogapi.payloads.ApiResponse;
import com.app.blogapi.payloads.CategoryDto;

public interface CategoryService {
    
    ResponseEntity<List<CategoryDto>> getAllCategory();
    ResponseEntity<CategoryDto> getCategoryById(int id);
    
    ResponseEntity<CategoryDto> createCategory(CategoryDto categoryDto);
    ResponseEntity<CategoryDto> updateCategory(int id, CategoryDto categoryDto);

    ResponseEntity<ApiResponse> deleteCategory(int id);
}
