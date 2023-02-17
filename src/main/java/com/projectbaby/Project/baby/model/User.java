package com.projectbaby.Project.baby.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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

    @NotNull
    private String username;

    @Email
    @NotNull
    private String email;

    @NotNull
    @Min(value = 6, message = "Password should be at least 6 characters")
    @Max(value = 12, message = "Password should not be greater than 12 characters")
    private String password;

    @OneToOne
    private Baby baby;

}
