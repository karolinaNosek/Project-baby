package com.projectbaby.Project.baby.activity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name="activities")
public class Bath extends AbstractActivity {

    @OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private String eveningBath;

    public Bath(String activityName, LocalTime activityStartTime, LocalTime activityEndTime) {
        super(activityName, activityStartTime, activityEndTime);
    }
}

