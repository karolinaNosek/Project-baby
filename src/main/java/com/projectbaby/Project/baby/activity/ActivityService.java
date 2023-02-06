package com.projectbaby.Project.baby.activity;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {

    private ActivityRepository activityRepository;

    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public List<Activity> activities() {
        List<Activity> allActivities = activityRepository.findAll();
        return allActivities;
    }

    public Activity save(Activity activity) {
        return activityRepository.save(activity);
    }

    public Activity update(int id, Activity updatedActivity) {
        Activity activityById = activityRepository.findById((long) id).orElseThrow(() -> new IllegalArgumentException());
        activityById.setActivityName(updatedActivity.getActivityName());
        activityById.setActivityStartTime(updatedActivity.getActivityStartTime());
        activityById.setActivityEndTime(updatedActivity.getActivityEndTime());
        return activityRepository.save(activityById);
    }

    public void delete(int id) {
        if (activityRepository.existsById((long) id)) {
            activityRepository.deleteById((long) id);
        } else {
            throw new IllegalArgumentException();
        }
    }
}