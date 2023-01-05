package com.projectbaby.Project.baby.activity;

import lombok.*;

import java.time.LocalTime;
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Play extends AbstractActivity {
    private String manipulativeGames;
    private String constructionGames;
    private String sensoryGames;
    private String socialGames;
    private String rhytmAndMovementGames;

    public Play(String activityName, LocalTime activityStartTime, LocalTime activityEndTime) {
        super(activityName, activityStartTime, activityEndTime);
    }
}
