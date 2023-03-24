package com.projectbaby.Project.baby.service;

import com.projectbaby.Project.baby.model.dto.activity.ActivityDTO;
import com.projectbaby.Project.baby.model.entity.activity.Activity;
import com.projectbaby.Project.baby.repository.ActivityRepository;
import com.projectbaby.Project.baby.exception.ResourceNotFoundException;
import com.projectbaby.Project.baby.strategies.ActivityMappingStrategy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityService {

    private ActivityRepository activityRepository;
    private ActivityMappingStrategy activityMappingStrategy;

    public ActivityService(ActivityRepository activityRepository, ActivityMappingStrategy activityMappingStrategy) {

        this.activityRepository = activityRepository;
        this.activityMappingStrategy = activityMappingStrategy;
    }

    public List<ActivityDTO> activitiesDTO() {
        List<Activity> allActivities = activityRepository.findAll();
        List<ActivityDTO> activitiesDTO = allActivities
                .stream()
                .map(activityMappingStrategy::mapToDTO)
                .collect(Collectors.toList());
        return activitiesDTO;
    }

    public ActivityDTO save(ActivityDTO activityDTO) {
        Activity activity = activityMappingStrategy.mapToEntity(activityDTO);
        activityRepository.save(activity);
        ActivityDTO activityDTO1 = activityMappingStrategy.mapToDTO(activity);
        return activityDTO1;
    }

    public ActivityDTO update(int id, ActivityDTO updatedActivityDTO) {
        Activity activityById = activityMappingStrategy.mapToEntity(updatedActivityDTO);
        activityRepository
                .findById((long) id)
                .orElseThrow(() -> new ResourceNotFoundException("Activity not found for this id: " + id ));
        activityById.setActivityName(updatedActivityDTO.getActivityName());
        activityById.setActivityStartTime(updatedActivityDTO.getActivityStartTime());
        activityById.setActivityEndTime(updatedActivityDTO.getActivityEndTime());
        activityRepository.save(activityById);
        ActivityDTO activityDTO2 = mapToDTO (activityById);
        return activityDTO2;
    }

    public void delete(int id) {
        if (activityRepository.existsById((long) id)) {
            activityRepository.deleteById((long) id);
        } else {
            throw new IllegalArgumentException();
        }
    }

}