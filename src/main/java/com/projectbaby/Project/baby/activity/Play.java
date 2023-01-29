package com.projectbaby.Project.baby.activity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="activities")
public class Play extends Activity {

    private String manipulativeGames;

    private String constructionGames;

    private String sensoryGames;

    private String socialGames;

    private String rhytmAndMovementGames;

    public Play(String activityName, LocalTime activityStartTime, LocalTime activityEndTime) {
        super(activityName, activityStartTime, activityEndTime);
    }
}
