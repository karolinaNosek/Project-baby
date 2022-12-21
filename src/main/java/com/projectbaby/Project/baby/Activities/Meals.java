package com.projectbaby.Project.baby.Activities;

public class Meals extends AbstractActivities{
    private String breastFeeding;
    private String modificatedMilk;
    private String solidMeals;

    public Meals(String activityName,
                 int activityStartTime,
                 int activityEndTime,
                 String breastFeeding,
                 String modificatedMilk,
                 String solidMeals) {
        super(activityName, activityStartTime, activityEndTime);
        this.breastFeeding = breastFeeding;
        this.modificatedMilk = modificatedMilk;
        this.solidMeals = solidMeals;
    }

    public Meals(String activityName, int activityStartTime, int activityEndTime) {
        super(activityName, activityStartTime, activityEndTime);

    }
}