package com.projectbaby.Project.baby.Activities;

public class Diapers extends AbstractActivities{

    private String pee;
    private String poo;

    public Diapers(String activityName,
                   int activityStartTime,
                   int activityEndTime,
                   String pee,
                   String poo) {
        super(activityName, activityStartTime, activityEndTime);
        this.pee = pee;
        this.poo = poo;
    }

    public Diapers(String activityName, int activityStartTime, int activityEndTime) {
        super(activityName, activityStartTime, activityEndTime);
    }
}
