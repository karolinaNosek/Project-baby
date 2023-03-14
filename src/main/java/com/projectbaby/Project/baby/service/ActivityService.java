package com.projectbaby.Project.baby.service;

import com.projectbaby.Project.baby.model.dto.activity.ActivityDTO;
import com.projectbaby.Project.baby.model.entity.activity.Activity;
import com.projectbaby.Project.baby.repository.ActivityRepository;
import com.projectbaby.Project.baby.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityService {

    private ActivityRepository activityRepository;

    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public List<ActivityDTO> activitiesDTO() {
        List<Activity> allActivities = activityRepository.findAll();
        List<ActivityDTO> activitiesDTO = allActivities
                .stream()
                .map(this::mapToActivityDTO)
                .collect(Collectors.toList());
        return activitiesDTO;
    }

    public ActivityDTO save(ActivityDTO activityDTO) {
        Activity activity = mapToActivity (activityDTO);
        activityRepository.save(activity);
        ActivityDTO activityDTO1 = mapToActivityDTO(activity);
        return activityDTO1;
    }

    public ActivityDTO update(int id, ActivityDTO updatedActivityDTO) throws ResourceNotFoundException {
        Activity activityById = mapToActivity (updatedActivityDTO);
        activityRepository
                .findById((long) id)
                .orElseThrow((new ResourceNotFoundException("Activity not found for this id: " + id )));
        activityById.setActivityName(updatedActivity.getActivityName());
        activityById.setActivityStartTime(updatedActivity.getActivityStartTime());
        activityById.setActivityEndTime(updatedActivity.getActivityEndTime());
        activityRepository.save(activityById);
        ActivityDTO activityDTO2 = mapToActivityDTO (activityById);
        return activityDTO2;
    }

    public void delete(int id) {
        if (activityRepository.existsById((long) id)) {
            activityRepository.deleteById((long) id);
        } else {
            throw new IllegalArgumentException();
        }
    }
    private ActivityDTO mapToActivityDTO (Activity activity) {
        ActivityDTO activityDTO = new ActivityDTO();
        activityDTO.setId(activity.getId());
        activityDTO.setActivityName(activity.getActivityName());
        activityDTO.setActivityStartTime(activity.getActivityStartTime());
        activityDTO.setActivityEndTime(activity.getActivityEndTime());
        return activityDTO;
    }
    private Activity mapToActivity (ActivityDTO activityDTO) {
      Activity activity = new Activity();
        activity.setId(activityDTO.getId());
        activity.setActivityName(activityDTO.getActivityName());
        activity.setActivityStartTime(activityDTO.getActivityStartTime());
        activity.setActivityEndTime(activityDTO.getActivityEndTime());
      return activity;
    }

}