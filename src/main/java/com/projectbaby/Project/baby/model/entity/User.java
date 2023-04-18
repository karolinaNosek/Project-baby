package com.projectbaby.Project.baby.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //@NotBlank
//    @Pattern(regexp = "a-z")
    private String username;

    @Email
    private String email;

//    @NotBlank
//    @Min(value = 6, message = "Password should be at least 6 characters")
//    @Max(value = 12, message = "Password should not be greater than 12 characters")
//    @Pattern(regexp = "a-z")
    private String password;

    @OneToOne
    private Baby baby;

}
