package com.app.blogapi.payloads;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto {
    
    private int categoryId;

    @NotEmpty
    private String categoryTitle;

    @NotEmpty
    @NotBlank
    private String categoryDescription;
}
