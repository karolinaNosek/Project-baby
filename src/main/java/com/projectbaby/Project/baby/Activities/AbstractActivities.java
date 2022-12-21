package com.projectbaby.Project.baby.Activities;

public abstract class AbstractActivities {
    private String activityName;
    private int activityStartTime;
    private int activityEndTime;


    public AbstractActivities(String activityName, int activityStartTime, int activityEndTime) {
        this.activityName = activityName;
        this.activityStartTime = activityStartTime;
        this.activityEndTime = activityEndTime;    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public int getActivityStartTime() {
        return activityStartTime;
    }

    public void setActivityStartTime(int activityStartTime) {
        this.activityStartTime = activityStartTime;
    }

    public int getActivityEndTime() {
        return activityEndTime;
    }

    public void setActivityEndTime(int activityEndTime) {
        this.activityEndTime = activityEndTime;
    }
}
