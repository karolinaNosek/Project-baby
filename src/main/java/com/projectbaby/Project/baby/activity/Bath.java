package com.projectbaby.Project.baby.activity;

import lombok.*;

import java.time.LocalTime;
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Bath extends AbstractActivity {
    @Getter(value = AccessLevel.PRIVATE)
    @Setter(value = AccessLevel.PRIVATE)
    private String eveningBath;


    public Bath(String activityName, LocalTime activityStartTime, LocalTime activityEndTime) {
        super(activityName, activityStartTime, activityEndTime);
    }
}

