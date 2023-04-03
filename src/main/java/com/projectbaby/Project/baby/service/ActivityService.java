package com.projectbaby.Project.baby.service;

import com.projectbaby.Project.baby.model.dto.activity.ActivityDTO;
import com.projectbaby.Project.baby.model.entity.activity.Activity;
import com.projectbaby.Project.baby.repository.ActivityRepository;
import com.projectbaby.Project.baby.exception.ResourceNotFoundException;
import com.projectbaby.Project.baby.strategies.ActivityMappingStrategy;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityService {

    private ActivityRepository activityRepository;
    private Collection<ActivityMappingStrategy> strategies;

    public ActivityService(ActivityRepository activityRepository, Collection<ActivityMappingStrategy> strategies) {
        this.activityRepository = activityRepository;
        this.strategies = strategies;
    }

    public List<ActivityDTO> activitiesDTO() {
        List<Activity> allActivities = activityRepository.findAll();
        List<ActivityDTO> activityDTOS = new ArrayList<>();
        for (Activity activity: allActivities) {
            final ActivityMappingStrategy activityMappingStrategy = matchStrategy(activity);
            final ActivityDTO activityDTO = activityMappingStrategy.mapToDTO(activity);
            activityDTOS.add(activityDTO);
        }

        return activityDTOS;
    }

    public ActivityDTO save(ActivityDTO activityDTO) {
        final Activity activity = matchStrategy(activityDTO).mapToEntity(activityDTO);

        final Activity savedActivity = activityRepository.save(activity);

        final ActivityDTO savedActivityDTO = matchStrategy(savedActivity).mapToDTO(savedActivity);
        return savedActivityDTO;
    }

    public ActivityDTO update(int id, ActivityDTO updatedActivityDTO) {
        final Activity activityById = matchStrategy(updatedActivityDTO).mapToEntity(updatedActivityDTO);
        activityRepository
                .findById((long) id)
                .orElseThrow(() -> new ResourceNotFoundException("Activity not found for this id: " + id ));
        activityById.setActivityName(updatedActivityDTO.getActivityName());
        activityById.setActivityStartTime(updatedActivityDTO.getActivityStartTime());
        activityById.setActivityEndTime(updatedActivityDTO.getActivityEndTime());
        activityRepository.save(activityById);
        final ActivityDTO activityDTO2 = matchStrategy(activityById).mapToDTO(activityById);
        return activityDTO2;
    }

    public void delete(int id) {
        if (activityRepository.existsById((long) id)) {
            activityRepository.deleteById((long) id);
        } else {
            throw new IllegalArgumentException();
        }
    }

    private ActivityMappingStrategy matchStrategy(ActivityDTO activityDTO) {
        return strategies.stream()
                .filter(strategy -> strategy.match(activityDTO))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unable to chose mapping strategy for given type"));
    }

    private ActivityMappingStrategy matchStrategy(Activity activity) {
        return strategies.stream()
                .filter(strategy -> strategy.match(activity))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unable to chose mapping strategy for given type"));
    }

}