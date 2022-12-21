package com.projectbaby.Project.baby.Activities;

public class Walk extends AbstractActivities{

    private String playground;
    private String park;

    public Walk(String activityName,
                int activityStartTime,
                int activityEndTime,
                String playground,
                String park) {
        super(activityName, activityStartTime, activityEndTime);
        this.playground = playground;
        this.park = park;
    }

    public Walk(String activityName, int activityStartTime, int activityEndTime) {
        super(activityName, activityStartTime, activityEndTime);
    }
}
