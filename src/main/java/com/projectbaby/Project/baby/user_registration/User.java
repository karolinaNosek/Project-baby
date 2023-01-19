package com.projectbaby.Project.baby.user_registration;

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
    @OneToOne
    private String username;

    @Column (name = "email")
    @NonNull
    @OneToOne
    private String email;

    @Column (name = "password")
    @NonNull
    @OneToOne
    private String password;


}
