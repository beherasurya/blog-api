package com.app.blogapi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.blogapi.payloads.CategoryDto;
import com.app.blogapi.services.CategoryService;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    CategoryService categoryService;
    
    @GetMapping("/category")
    public ResponseEntity<List<CategoryDto>> getAllCategory(){

       return categoryService.getAllCategory();
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable int id){
       return  categoryService.getCategoryById(id);
    }

    @PostMapping("/category")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
        return categoryService.createCategory(categoryDto);
    }

    @PutMapping("/category/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable int id ,@Valid @RequestBody CategoryDto categoryDto){

        return categoryService.updateCategory(id, categoryDto);
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<String> deleteCategory(int id){

        return categoryService.deleteCategory(id);
    }


}
