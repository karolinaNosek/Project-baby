package com.projectbaby.Project.baby.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank
    private String name;

    @JsonFormat(pattern = "MM/DD/YYYY")
    @Past
    private LocalDate dateOfBirth;

    @NotBlank
    private String sex;

    @Size(min=40, max=150) // height unit is centimeters
    private int height;

    @Size(min=1000, max=15000) // weight unit is grams
    private int weight;

}
