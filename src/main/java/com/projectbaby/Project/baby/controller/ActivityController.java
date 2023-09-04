package com.projectbaby.Project.baby.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.projectbaby.Project.baby.model.dto.activity.ActivityDTO;
import com.projectbaby.Project.baby.model.entity.activity.Activity;
import com.projectbaby.Project.baby.service.ActivityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/v1/activities")
public class ActivityController {

    private ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping
    public ResponseEntity<List<ActivityDTO>> getAllActivities (){
        return ResponseEntity.ok(activityService.getAllActivities());
    }

    @PostMapping
    public ResponseEntity<ActivityDTO> addActivity (@RequestBody ActivityDTO activityDTO) {
        return ResponseEntity.ok(activityService.saveActivity(activityDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActivityDTO> updateActivity (@PathVariable(value = "id") Integer id, @RequestBody ActivityDTO updatedActivityDTO)  {
        return ResponseEntity.ok(activityService.updateActivity(id, updatedActivityDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Activity> deleteActivity (@PathVariable(value = "id") Integer id) {
        activityService.deleteActivity(id);
        return ResponseEntity.ok().build();
    }
}
