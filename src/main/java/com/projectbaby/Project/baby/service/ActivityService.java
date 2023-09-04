package com.projectbaby.Project.baby.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.projectbaby.Project.baby.model.dto.activity.ActivityDTO;
import com.projectbaby.Project.baby.model.dto.activity.MealDTO;
import com.projectbaby.Project.baby.model.entity.activity.Activity;
import com.projectbaby.Project.baby.model.entity.activity.Meal;
import com.projectbaby.Project.baby.repository.ActivityRepository;
import com.projectbaby.Project.baby.exception.ResourceNotFoundException;
import com.projectbaby.Project.baby.strategies.ActivityMappingStrategy;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityService {

    private ActivityRepository activityRepository;
    private Collection<ActivityMappingStrategy> mappingStrategies;

    public ActivityService(ActivityRepository activityRepository, Collection<ActivityMappingStrategy> mappingStrategies) {
        this.activityRepository = activityRepository;
        this.mappingStrategies = mappingStrategies;
    }

    public List<ActivityDTO> getAllActivities() {
        return activityRepository.findAll().stream()
                .map(activity -> matchStrategy(activity).mapToDTO(activity))
                .collect(Collectors.toList());
    }

    public ActivityDTO saveActivity (ActivityDTO activityDTO) {
        final Activity activity = matchStrategy(activityDTO).mapToEntity(activityDTO);

        final Activity savedActivity = activityRepository.save(activity);

        final ActivityDTO savedActivityDTO = matchStrategy(savedActivity).mapToDTO(savedActivity);
        return savedActivityDTO;
    }

    public ActivityDTO updateActivity (Integer id, ActivityDTO updatedActivityDTO)  {
        Activity existingActivity = activityRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Activity not found for this id: " + id ));
        existingActivity.setActivityName(updatedActivityDTO.getActivityName());
        existingActivity.setActivityStartTime(updatedActivityDTO.getActivityStartTime());
        existingActivity.setActivityEndTime(updatedActivityDTO.getActivityEndTime());
        activityRepository.save(existingActivity);
        final ActivityDTO existingActivityDTO = matchStrategy(existingActivity).mapToDTO(existingActivity);
        return existingActivityDTO;
    }

    public void deleteActivity (Integer id) {
        if (activityRepository.existsById(id)) {
            activityRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException();
        }
    }

    private ActivityMappingStrategy matchStrategy(ActivityDTO activityDTO) {
        return mappingStrategies.stream()
                .filter(strategy -> strategy.match(activityDTO))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unable to chose mapping strategy for given type"));
    }

    private ActivityMappingStrategy matchStrategy(Activity activity) {
        return mappingStrategies.stream()
                .filter(strategy -> strategy.match(activity))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unable to chose mapping strategy for given type"));
    }

}