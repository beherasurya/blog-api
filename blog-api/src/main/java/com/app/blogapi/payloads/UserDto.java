package com.app.blogapi.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserDto {
    
    private String name;
    private int id;
    
    private String email;
    private String password;

    private String about;
}
