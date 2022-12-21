package com.projectbaby.Project.baby.Activities;

public class Sleep extends AbstractActivities {

    private String nap;
    private String deepSleep;

    public Sleep(String activityName,
                 int activityStartTime,
                 int activityEndTime,
                 String nap,
                 String deepSleep) {
        super(activityName, activityStartTime, activityEndTime);
        this.nap = nap;
        this.deepSleep = deepSleep;
    }

    public Sleep(String activityName, int activityStartTime, int activityEndTime) {
        super(activityName, activityStartTime, activityEndTime);
    }
}

