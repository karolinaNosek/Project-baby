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
    public ResponseEntity<List<ActivityDTO>> getAllActivitiesDTO (){
        return ResponseEntity.ok(activityService.getAllActivitiesDTO());
    }

    @PostMapping
    public ResponseEntity<ActivityDTO> addActivityDTO (@RequestBody ActivityDTO activityDTO) {
        return ResponseEntity.ok(activityService.saveActivityDTO(activityDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActivityDTO> updateActivityDTO (@PathVariable(value = "id") Integer id, @RequestBody ActivityDTO updatedActivityDTO)  {
        return ResponseEntity.ok(activityService.updateActivityDTO(id, updatedActivityDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Activity> deleteActivity (@PathVariable(value = "id") Integer id) {
        activityService.deleteActivity(id);
        return ResponseEntity.ok().build();
    }
}
