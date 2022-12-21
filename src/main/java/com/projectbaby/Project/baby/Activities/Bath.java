package com.projectbaby.Project.baby.Activities;

public class Bath extends AbstractActivities{

    private String eveningBath;

    public Bath(String activityName,
                int activityStartTime,
                int activityEndTime,
                String eveningBath) {
        super(activityName, activityStartTime, activityEndTime);
        this.eveningBath = eveningBath;
    }

    public Bath(String activityName, int activityStartTime, int activityEndTime) {
        super(activityName, activityStartTime, activityEndTime);
    }
}

