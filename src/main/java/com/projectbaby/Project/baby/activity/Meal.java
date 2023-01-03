package com.projectbaby.Project.baby.activity;

import lombok.*;

import java.time.LocalTime;
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Meal extends AbstractActivity {
    @Getter(value = AccessLevel.PRIVATE)
    @Setter(value = AccessLevel.PRIVATE)
    private String breastFeeding;
    @Getter(value = AccessLevel.PRIVATE)
    @Setter(value = AccessLevel.PRIVATE)
    private String modificatedMilk;
    @Getter(value = AccessLevel.PRIVATE)
    @Setter(value = AccessLevel.PRIVATE)
    private String solidMeals;


    public Meal(String activityName, LocalTime activityStartTime, LocalTime activityEndTime) {
        super(activityName, activityStartTime, activityEndTime);
    }
}