package com.projectbaby.Project.baby.activity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="activities")
public class Play extends AbstractActivity {

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private String manipulativeGames;

    @OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private String constructionGames;

    @OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private String sensoryGames;

    @OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private String socialGames;

    @OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private String rhytmAndMovementGames;

    public Play(String activityName, LocalTime activityStartTime, LocalTime activityEndTime) {
        super(activityName, activityStartTime, activityEndTime);
    }
}
