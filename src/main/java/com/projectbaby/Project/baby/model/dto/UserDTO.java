package com.projectbaby.Project.baby.model.dto;

import com.projectbaby.Project.baby.model.entity.Baby;
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

    private String username;

    @Email
    private String email;

    private String password;

    private Baby baby;
}
