package com.projectbaby.Project.baby.activity;

import com.projectbaby.Project.baby.model.Baby;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="activities")
public class Walk extends Activity {

    private String playground;

    private String park;

    public Walk(String activityName, LocalTime activityStartTime, LocalTime activityEndTime) {
        super(activityName, activityStartTime, activityEndTime);
    }
}
