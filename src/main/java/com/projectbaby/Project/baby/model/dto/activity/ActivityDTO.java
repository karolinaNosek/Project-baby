package com.projectbaby.Project.baby.model.dto.activity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.projectbaby.Project.baby.model.entity.Baby;
import com.projectbaby.Project.baby.model.entity.activity.*;
import lombok.Data;

import java.time.LocalTime;

@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "class")
@JsonSubTypes({
        @JsonSubTypes.Type(value = BathDTO.class, name = "bath"),
        @JsonSubTypes.Type(value = DiaperDTO.class, name = "diaper"),
        @JsonSubTypes.Type(value = MealDTO.class, name = "meal"),
        @JsonSubTypes.Type(value = PlayDTO.class, name = "play"),
        @JsonSubTypes.Type(value = SleepDTO.class, name = "sleep"),
        @JsonSubTypes.Type(value = WalkDTO.class, name = "walk")
})
public class ActivityDTO {
    private Integer id;
    private String activityName;
    private LocalTime activityStartTime;
    private LocalTime activityEndTime;
    private Baby baby;

}
