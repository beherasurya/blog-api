package com.app.blogapi.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    
    public ResourceNotFoundException(int id){

        System.out.println("This resource id is not found in the Database: "+id);
    }

    public ResourceNotFoundException(){
        System.out.println("Resource Not Found");
    }

}
