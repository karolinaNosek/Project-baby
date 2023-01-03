package com.projectbaby.Project.baby.activity;

import lombok.*;

import java.time.LocalTime;
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Diaper extends AbstractActivity {
    @Getter(value = AccessLevel.PRIVATE)
    @Setter(value = AccessLevel.PRIVATE)
    private String pee;
    @Getter(value = AccessLevel.PRIVATE)
    @Setter(value = AccessLevel.PRIVATE)
    private String poo;


    public Diaper(String activityName, LocalTime activityStartTime, LocalTime activityEndTime) {
        super(activityName, activityStartTime, activityEndTime);
    }
}
