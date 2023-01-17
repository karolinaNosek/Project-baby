package com.projectbaby.Project.baby.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "babies")
public class Baby {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;
    @Column (name = "name")
    private String name;
//    @Column (name = "date_of_birth")
//    @DateTimeFormat (iso = DateTimeFormat.ISO.DATE)
//    private LocalDate dateOfBirth;
    @Column (name = "sex")
    private String sex;
    @Column (name = "height")
    private int height;
    @Column (name = "weight")
    private int weight;


}
