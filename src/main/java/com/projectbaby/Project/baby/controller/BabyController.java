package com.projectbaby.Project.baby.controller;

import com.projectbaby.Project.baby.activity.Activity;
import com.projectbaby.Project.baby.service.ActivityService;
import com.projectbaby.Project.baby.model.Baby;
import com.projectbaby.Project.baby.service.BabyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/v1/babies")
public class BabyController {

    private final BabyService babyService;

    public BabyController (BabyService babyService){
        this.babyService = babyService;
    }

    @GetMapping
    public ResponseEntity<List> getAllBabies() {
        return ResponseEntity.ok(babyService.getAllBabies());
    }
    @PostMapping
    public ResponseEntity<Baby> createBaby(@RequestBody Baby baby) {
        return ResponseEntity.ok(babyService.save(baby));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Baby> getBabyById (@PathVariable(value = "id") int id) {
        return ResponseEntity.ok(babyService.getBabyById(id));
    }
    @PutMapping ("/{id}")
    public ResponseEntity<Baby> update(@PathVariable(value = "id") int id, @RequestBody Baby updatedBaby){
        return ResponseEntity.ok(babyService.update(id, updatedBaby));
    }
    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> delete (@PathVariable(value = "id") int id) {
        babyService.delete(id);
        return ResponseEntity.ok().build();
    }

    @RestController
    @RequestMapping ("/api/v1/activities")
    public static class ActivityController {

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

        @PutMapping ("/{id}")
        public ResponseEntity<Activity> updateActivity (@PathVariable(value = "id") int id, @RequestBody Activity updatedActivity) {
            return ResponseEntity.ok(activityService.update(id, updatedActivity));
        }

        @DeleteMapping ("/{id}")
        public ResponseEntity<Void> deleteActivity (@PathVariable(value = "id") int id) {
            activityService.delete(id);
            return ResponseEntity.ok().build();
        }
    }
}
