package com.projectbaby.Project.baby.controller;

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
    public ResponseEntity<List> allActivities (){
        return ResponseEntity.ok(activityService.activities());
    }

    @PostMapping
    public ResponseEntity<Activity> addActivity (@RequestBody Activity activity) {
        return ResponseEntity.ok(activityService.save(activity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Activity> updateActivity (@PathVariable(value = "id") int id, @RequestBody Activity updatedActivity) {
        return ResponseEntity.ok(activityService.update(id, updatedActivity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Activity> deleteActivity (@PathVariable(value = "id") int id) {
        activityService.delete(id);
        return ResponseEntity.ok().build();
    }
}
