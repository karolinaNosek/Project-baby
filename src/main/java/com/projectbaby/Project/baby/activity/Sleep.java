package com.projectbaby.Project.baby.activity;

import lombok.*;

import java.time.LocalTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sleep extends AbstractActivity {
    private String nap;
    private String deepSleep;

    public Sleep(String activityName, LocalTime activityStartTime, LocalTime activityEndTime) {
        super(activityName, activityStartTime, activityEndTime);
    }
}

