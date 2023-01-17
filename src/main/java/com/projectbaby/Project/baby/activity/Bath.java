package com.projectbaby.Project.baby.activity;

import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bath extends AbstractActivity {
    private String eveningBath;

    public Bath(String activityName, LocalTime activityStartTime, LocalTime activityEndTime) {
        super(activityName, activityStartTime, activityEndTime);
    }
}

