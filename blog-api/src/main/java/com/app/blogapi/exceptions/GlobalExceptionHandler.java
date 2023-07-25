package com.app.blogapi.exceptions;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
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
    ResponseEntity<Map<String,String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){

        // ApiResponse apiResponse = new ApiResponse("Please give Valid input for the  attributes", false);

        // String apiResponse = exception.getFieldErrors().stream()
        // .map(fieldError -> fieldError.getField() + " - "+fieldError.getDefaultMessage()).collect(Collectors.joining(" , "));


        Map<String, String> apiResponse = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error) ->{
            String fieldName = ((FieldError)error).getField();
            String message = error.getDefaultMessage();

            apiResponse.put(fieldName, message);
        });
                
        return new ResponseEntity<Map<String,String>>(apiResponse, HttpStatus.NOT_ACCEPTABLE);

    }


}
