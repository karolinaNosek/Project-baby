package com.projectbaby.Project.baby.model;

import com.projectbaby.Project.baby.activity.Activity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

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
    private String name;

//    @Column (name = "baby_date_of_birth")
//    @DateTimeFormat (iso = DateTimeFormat.ISO.DATE)
//    private LocalDate dateOfBirth;

    @Column (name = "baby_sex")
    @NonNull
    private String sex;

    @Column (name = "baby_height")
    @NonNull
    private int height;

    @Column (name = "baby_weight")
    @NonNull
    private int weight;

    @OneToMany (mappedBy = "baby")
    List<Activity> activities;

}
