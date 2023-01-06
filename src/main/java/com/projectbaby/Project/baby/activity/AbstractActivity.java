package com.projectbaby.Project.baby.activity;

import lombok.*;

import java.time.LocalTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractActivity {
    private String activityName;
    private LocalTime activityStartTime;
    private LocalTime activityEndTime;

}
