package com.projectbaby.Project.baby.activity;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalkService {

    private WalkRepository walkRepository;

    public WalkService(WalkRepository walkRepository) {
        this.walkRepository = walkRepository;
    }

    public List<Activity> activities() {
        List<Activity> walkActivities = walkRepository.findAll();
        return walkActivities;
    }

    public Activity save(Walk walk) {
        return walkRepository.save(walk);
    }

    public Activity update(int id, Activity updatedWalkActivity) {
        Activity activityWalkById = walkRepository.findById((long) id).orElseThrow(() -> new IllegalArgumentException());
        activityWalkById.setActivityName(updatedWalkActivity.getActivityName());
        activityWalkById.setActivityStartTime(updatedWalkActivity.getActivityStartTime());
        activityWalkById.setActivityEndTime(updatedWalkActivity.getActivityEndTime());
        return walkRepository.save(activityWalkById);
    }

    public void delete(int id) {
        if (walkRepository.existsById((long) id)) {
            walkRepository.deleteById((long) id);
        } else {
            throw new IllegalArgumentException();
        }
    }
}
