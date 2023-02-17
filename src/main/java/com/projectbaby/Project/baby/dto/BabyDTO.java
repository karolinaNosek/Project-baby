package com.projectbaby.Project.baby.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class BabyDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

}
