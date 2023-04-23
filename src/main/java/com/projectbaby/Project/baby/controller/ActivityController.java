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
    public ResponseEntity<List<ActivityDTO>> allActivitiesDTO (){
        return ResponseEntity.ok(activityService.activitiesDTO());
    }

    @PostMapping
    public ResponseEntity<ActivityDTO> addActivity (@RequestBody ActivityDTO activityDTO) throws JsonProcessingException {
        return ResponseEntity.ok(activityService.save(activityDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActivityDTO> update (@PathVariable(value = "id") int id, @RequestBody ActivityDTO updatedActivityDTO) throws JsonProcessingException {
        return ResponseEntity.ok(activityService.update(id, updatedActivityDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Activity> deleteActivity (@PathVariable(value = "id") int id) {
        activityService.delete(id);
        return ResponseEntity.ok().build();
    }
}
