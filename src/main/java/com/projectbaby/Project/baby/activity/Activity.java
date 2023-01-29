package com.projectbaby.Project.baby.activity;

import com.projectbaby.Project.baby.model.Baby;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity (name="activities")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn (name="ACTIVITY_TYPE", discriminatorType=DiscriminatorType.STRING)
public abstract class Activity {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;
    private String activityName;
    private LocalTime activityStartTime;
    private LocalTime activityEndTime;

    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn (name="baby_id")
    private Baby baby;

    public Activity(String activityName, LocalTime activityStartTime, LocalTime activityEndTime) {

    }
}
