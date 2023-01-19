package com.projectbaby.Project.baby.activity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="activities")
public class Walk extends AbstractActivity {

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private String playground;

    @OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private String park;

    public Walk(String activityName, LocalTime activityStartTime, LocalTime activityEndTime) {
        super(activityName, activityStartTime, activityEndTime);
    }
}
