package com.app.blogapi.services.serviceimplementation;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.blogapi.entities.Category;
import com.app.blogapi.exceptions.ResourceNotFoundException;
import com.app.blogapi.payloads.CategoryDto;
import com.app.blogapi.repositories.CategoryRepository;
import com.app.blogapi.services.CategoryService;

@Service
public class CategoryServiceImplementation implements CategoryService{

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ResponseEntity<List<CategoryDto>> getAllCategory() {
       if(categoryRepository.findAll().isEmpty()){
            throw new ResourceNotFoundException("No Resource  found in the Database");
       } 

        List<Category> category = categoryRepository.findAll();
        List<CategoryDto> categoryDto = category.stream()
        .map(record ->modelMapper.map(record,CategoryDto.class))
                .collect(Collectors.toList());


        return new ResponseEntity<List<CategoryDto>>(categoryDto, HttpStatus.OK);
       
    }

    @Override
    public ResponseEntity<CategoryDto> getCategoryById(int id) {
        
        Category category = categoryRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Resource you are trying to fetch is not found", id));
    
        return new ResponseEntity<CategoryDto>
        ( modelMapper.map(category, CategoryDto.class), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CategoryDto> createCategory(CategoryDto categoryDto) {
        Category category = modelMapper.map(categoryDto, Category.class);
        category = categoryRepository.save(category);

        categoryDto = modelMapper.map(category, CategoryDto.class);
        return new ResponseEntity<CategoryDto>(categoryDto, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<CategoryDto> updateCategory(int id, CategoryDto categoryDto) {
      if(categoryRepository.findById(id).isEmpty()){
        throw new ResourceNotFoundException("Resource you are trying to update is not Found", id);
      }

        categoryDto.setCategoryId(id);
       Category category = modelMapper.map(categoryDto, Category.class);

        category = categoryRepository.save(category);
        categoryDto = modelMapper.map(category, CategoryDto.class);

        return new ResponseEntity<CategoryDto>(categoryDto, HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<String> deleteCategory(int id) {
        if(categoryRepository.findById(id).isEmpty()){
            throw new ResourceNotFoundException("Resource you are trying to delete is not Found ", id);
        }

        categoryRepository.deleteById(id);
        return new ResponseEntity<String>("Resource Deleted for ID : "+id,HttpStatus.OK);


    }
    
}
