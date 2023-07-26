package com.app.blogapi.services.serviceimplementation;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.blogapi.exceptions.ResourceNotFoundException;
import com.app.blogapi.payloads.CategoryDto;
import com.app.blogapi.repositories.CategoryRepository;
import com.app.blogapi.services.CategoryService;

@Service
public class CategoryServiceImplementation implements CategoryService{

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public ResponseEntity<List<CategoryDto>> getAllCategory() {
       if(categoryRepository.findAll().isEmpty()){
            throw new ResourceNotFoundException("No Resource is found in the Database");
       } 

       
       
    }

    @Override
    public ResponseEntity<CategoryDto> getCategoryById() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCategoryById'");
    }

    @Override
    public ResponseEntity<CategoryDto> createCategory(CategoryDto categoryDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createCategory'");
    }

    @Override
    public ResponseEntity<CategoryDto> updateCategory(int id, CategoryDto categoryDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateCategory'");
    }

    @Override
    public ResponseEntity<String> deleteCategory(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteCategory'");
    }
    
}
