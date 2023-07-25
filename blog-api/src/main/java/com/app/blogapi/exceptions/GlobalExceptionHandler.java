package com.app.blogapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.blogapi.payloads.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    
    @ExceptionHandler(ResourceNotFoundException.class)
    ResponseEntity<ApiResponse> handleResourceNotFoundExceptions(ResourceNotFoundException resourceNotFoundException){

        ApiResponse apiResponse = new ApiResponse(resourceNotFoundException.getMessage()+" for ID: "+resourceNotFoundException.getId(), false);
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ApiResponse> handleMethodArgumentNotValidException(){

        ApiResponse apiResponse = new ApiResponse("Please give Valid input for the  attributes", false);
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_ACCEPTABLE);

    }


}
