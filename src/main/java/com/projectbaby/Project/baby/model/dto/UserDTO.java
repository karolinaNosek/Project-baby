package com.projectbaby.Project.baby.model.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UserDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

//    @NotBlank
//    @Pattern(regexp = "a-z")
    private String username;

    @Email
//    @NotBlank
    private String email;

//    @NotBlank
//    @Pattern(regexp = "a-z")
//    @Min(value = 6, message = "Password should be at least 6 characters")
//    @Max(value = 12, message = "Password should not be greater than 12 characters")
    private String password;
}
