package com.projectbaby.Project.baby.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "babies")
public class Baby {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    @Column (name = "baby_name")
    @NonNull
    @OneToOne
    private String name;

//    @Column (name = "baby_date_of_birth")
//    @DateTimeFormat (iso = DateTimeFormat.ISO.DATE)
//    private LocalDate dateOfBirth;

    @Column (name = "baby_sex")
    @NonNull
    @OneToOne
    private String sex;

    @Column (name = "baby_height")
    @NonNull
    @OneToOne
    private int height;

    @Column (name = "baby_weight")
    @NonNull
    @OneToOne
    private int weight;

}
