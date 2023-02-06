package com.projectbaby.Project.baby.user_registration;

import com.projectbaby.Project.baby.model.Baby;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column (name = "username")
    @NonNull
    private String username;

    @Column (name = "email")
    @NonNull
    private String email;

    @Column (name = "password")
    @NonNull
    private String password;




}
