package com.projectbaby.Project.baby.activity;

import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Diaper extends AbstractActivity {
    private String pee;
    private String poo;

    public Diaper(String activityName, LocalTime activityStartTime, LocalTime activityEndTime) {
        super(activityName, activityStartTime, activityEndTime);
    }
}
