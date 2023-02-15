package com.projectbaby.Project.baby.model;

import com.projectbaby.Project.baby.activity.Activity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "babies")
public class Baby {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String name;

//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//    private LocalDate dateOfBirth;

    @NonNull
    private String sex;

    @NonNull
    private int height;

    @NonNull
    private int weight;

    @OneToMany (mappedBy = "baby")
    private List<Activity> activities;


}
