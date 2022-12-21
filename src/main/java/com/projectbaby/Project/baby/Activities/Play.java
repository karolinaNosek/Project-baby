package com.projectbaby.Project.baby.Activities;

public class Play extends AbstractActivities {

    private String manipulativeGames;
    private String constructionGames;
    private String sensoryGames;
    private String socialGames;
    private String rhytmAndMovementGames;

    public Play(String activityName,
                int activityStartTime,
                int activityEndTime,
                String manipulativeGames,
                String constructionGames,
                String sensoryGames,
                String socialGames,
                String rhytmAndMovementGames) {
        super(activityName, activityStartTime, activityEndTime);
        this.manipulativeGames = manipulativeGames;
        this.constructionGames = constructionGames;
        this.sensoryGames = sensoryGames;
        this.socialGames = socialGames;
        this.rhytmAndMovementGames = rhytmAndMovementGames;
    }

    public Play(String activityName, int activityStartTime, int activityEndTime) {
        super(activityName, activityStartTime, activityEndTime);
    }
}
