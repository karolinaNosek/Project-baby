package com.projectbaby.Project.baby.model.entity.activity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Meal extends Activity {
    private String breastFeeding;
    private String modificatedMilk;
    private String solidMeals;

}