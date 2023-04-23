package com.projectbaby.Project.baby.model.entity.activity;

import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonTypeName("meal")
public class Meal extends Activity {
    private String breastFeeding;
    private String modificatedMilk;
    private String solidMeals;

}