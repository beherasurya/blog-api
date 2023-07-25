package com.app.blogapi.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResourceNotFoundException extends RuntimeException {
    
    
    private String message;
    private int id;

    public ResourceNotFoundException(String message){
        this.message = message;
    }

}
