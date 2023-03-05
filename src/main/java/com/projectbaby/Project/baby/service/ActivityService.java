package com.projectbaby.Project.baby.service;

import com.projectbaby.Project.baby.model.entity.activity.Activity;
import com.projectbaby.Project.baby.repository.ActivityRepository;
import com.projectbaby.Project.baby.service.Exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Activity update(int id, Activity updatedActivity) throws ResourceNotFoundException {
        Activity activityById = activityRepository
                .findById((long) id)
                .orElseThrow((new ResourceNotFoundException("Activity not found for this id: " + id ));
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