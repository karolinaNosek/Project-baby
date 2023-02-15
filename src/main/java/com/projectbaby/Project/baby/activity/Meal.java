package com.projectbaby.Project.baby.activity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Meal extends Activity {
    private String breastFeeding;
    private String modificatedMilk;
    private String solidMeals;

}