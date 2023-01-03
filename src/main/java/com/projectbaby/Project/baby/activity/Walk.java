package com.projectbaby.Project.baby.activity;

import lombok.*;

import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor(access= AccessLevel.PUBLIC)
public class Walk extends AbstractActivity {

    @Getter(value = AccessLevel.PRIVATE)
    @Setter(value = AccessLevel.PRIVATE)
    private String playground;
    @Getter(value = AccessLevel.PRIVATE)
    @Setter(value = AccessLevel.PRIVATE)
    private String park;


    public Walk(String activityName, LocalTime activityStartTime, LocalTime activityEndTime) {
        super(activityName, activityStartTime, activityEndTime);
    }
}
