package com.projectbaby.Project.baby.activity;

import lombok.*;

import java.time.LocalTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Walk extends AbstractActivity {
    private String playground;
    private String park;

    public Walk(String activityName, LocalTime activityStartTime, LocalTime activityEndTime) {
        super(activityName, activityStartTime, activityEndTime);
    }
}
