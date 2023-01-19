package com.projectbaby.Project.baby.activity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="activities")
public class Meal extends AbstractActivity {

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private String breastFeeding;

    @OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private String modificatedMilk;

    @OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private String solidMeals;

    public Meal(String activityName, LocalTime activityStartTime, LocalTime activityEndTime) {
        super(activityName, activityStartTime, activityEndTime);
    }
}