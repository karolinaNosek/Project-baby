package com.projectbaby.Project.baby.model;

import com.projectbaby.Project.baby.activity.Activity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
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

    @Size(min=2, max=30)
    @NotNull
    private String name;

    @DateTimeFormat(pattern = "MM/DD/YYYY")
    @Past
    @NotNull
    private LocalDate dateOfBirth;

    @NotNull
    private String sex;

    @NotNull
    @Size(min=40, max=150) // height unit is centimeters
    private int height;

    @NotNull
    @Size(min=1000, max=15000) // weight unit is grams
    private int weight;

    @OneToMany (mappedBy = "baby")
    private List<Activity> activities;

    @OneToOne (fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn (name="user_id")
    private User user;


}
