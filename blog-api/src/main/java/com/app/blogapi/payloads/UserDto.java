package com.app.blogapi.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserDto {
    
    @NotEmpty
    @Size(min = 3, max=20, message = "give valid name")
    private String name;

    private int id;
    
    @NotEmpty
    @Email(message = "give valid email")
    private String email;

    @NotEmpty
    @Size(min = 3, max =15, message = "give valid password")
    private String password;

    @NotEmpty
    private String about;
}
