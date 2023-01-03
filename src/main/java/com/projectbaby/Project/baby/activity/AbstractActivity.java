package com.projectbaby.Project.baby.activity;

import lombok.*;

import java.time.LocalTime;
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public abstract class AbstractActivity {
    @Getter(value = AccessLevel.PRIVATE)
    @Setter(value = AccessLevel.PRIVATE)
    private String activityName;
    @Getter(value = AccessLevel.PRIVATE)
    @Setter(value = AccessLevel.PRIVATE)
    private LocalTime activityStartTime;
    @Getter(value = AccessLevel.PRIVATE)
    @Setter(value = AccessLevel.PRIVATE)
    private LocalTime activityEndTime;



}
