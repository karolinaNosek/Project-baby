package com.projectbaby.Project.baby.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projectbaby.Project.baby.model.entity.activity.Activity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.Range;

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
    private Integer id;

    @Size(min=2, max=30)
    private String name;

    @JsonFormat(pattern = "yyyy/MM/dd")
    @Past
    private LocalDate dateOfBirth;

    private String sex;

    private int heightInCentimeters;

    private int weightInGrams;

    @OneToMany (mappedBy = "baby")
    private List<Activity> activities;

    @OneToOne (fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn (name="user_id")
    private User user;


}
