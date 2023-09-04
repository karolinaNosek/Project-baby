package com.projectbaby.Project.baby.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projectbaby.Project.baby.model.entity.User;
import com.projectbaby.Project.baby.model.entity.activity.Activity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import org.mapstruct.Mapping;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Data
public class BabyDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Size(min=2, max=30)
    private String name;

    @JsonFormat(pattern = "yyyy/MM/dd")
    @Past
    private LocalDate dateOfBirth;

    private String sex;

    private int heightInCentimeters;

    private int weightInGrams;

    private List<Activity> activities;

    private User user;

}
