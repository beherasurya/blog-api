package com.app.blogapi.exceptions;

import java.util.stream.Collectors;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.blogapi.payloads.ApiResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.util.JSONPObject;

import netscape.javascript.JSObject;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    
    @ExceptionHandler(ResourceNotFoundException.class)
    ResponseEntity<ApiResponse> handleResourceNotFoundExceptions(ResourceNotFoundException resourceNotFoundException){

        ApiResponse apiResponse = new ApiResponse(resourceNotFoundException.getMessage()+" for ID: "+resourceNotFoundException.getId(), false);
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ApiResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){

        // ApiResponse apiResponse = new ApiResponse("Please give Valid input for the  attributes", false);

        String apiResponse = exception.getFieldErrors().stream()
        .map(fieldError -> fieldError.getField() + " - "+fieldError.getDefaultMessage()).collect(Collectors.joining(" , "));


        
        ApiResponse apiResponse2 = new ApiResponse(apiResponse, false);
        return new ResponseEntity<ApiResponse>(apiResponse2, HttpStatus.NOT_ACCEPTABLE);

    }


}
