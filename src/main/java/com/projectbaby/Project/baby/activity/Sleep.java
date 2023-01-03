package com.projectbaby.Project.baby.activity;

import lombok.*;

import java.time.LocalTime;
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Sleep extends AbstractActivity {
    @Getter(value = AccessLevel.PRIVATE)
    @Setter(value = AccessLevel.PRIVATE)
    private String nap;
    @Getter(value = AccessLevel.PRIVATE)
    @Setter(value = AccessLevel.PRIVATE)
    private String deepSleep;


    public Sleep(String activityName, LocalTime activityStartTime, LocalTime activityEndTime) {
        super(activityName, activityStartTime, activityEndTime);
    }
}

