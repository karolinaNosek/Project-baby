package com.projectbaby.Project.baby.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor (access= AccessLevel.PUBLIC)
@NoArgsConstructor
@Entity
@Table (name = "babies")
public class Baby {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;
    @Column (name = "name")
    private String name;
    @Column (name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Column (name = "sex")
    private String sex;
    @Column (name = "height")
    private int height;
    @Column (name = "weight")
    private int weight;


}
