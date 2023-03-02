package com.projectbaby.Project.baby.model.dto.activity;

import lombok.Data;

import java.time.LocalTime;

@Data
public class ActivityDTO {
    private Long id;
    private String activityName;
    private LocalTime activityStartTime;
    private LocalTime activityEndTime;

}
