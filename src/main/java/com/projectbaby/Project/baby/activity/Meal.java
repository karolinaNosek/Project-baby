package com.projectbaby.Project.baby.activity;

import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Meal extends AbstractActivity {
    private String breastFeeding;
    private String modificatedMilk;
    private String solidMeals;

    public Meal(String activityName, LocalTime activityStartTime, LocalTime activityEndTime) {
        super(activityName, activityStartTime, activityEndTime);
    }
}