package com.projectbaby.Project.baby.activity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public abstract class AbstractActivity {

    @OneToMany(mappedBy = "baby_name", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="name")
    private String activityName;

    @OneToMany(mappedBy = "baby_name", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private LocalTime activityStartTime;

    @OneToMany(mappedBy = "baby_name", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private LocalTime activityEndTime;

}
