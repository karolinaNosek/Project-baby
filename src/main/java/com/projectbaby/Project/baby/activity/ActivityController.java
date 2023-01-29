package com.projectbaby.Project.baby.activity;

import com.projectbaby.Project.baby.repository.BabyRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/activities")
public class ActivityController {

    private ActivityService activityService;
    private BabyRepository babyRepository;

    public ActivityController(ActivityService activityService, BabyRepository babyRepository) {
        this.activityService = activityService;
        this.babyRepository = babyRepository;
    }


    @GetMapping
    public ResponseEntity<List> allActivities (){
        return ResponseEntity.ok(activityService.activities());
    }

    // add activity
    @PostMapping
    public ResponseEntity<Activity> addActivity (@RequestBody Activity activity) {
        return ResponseEntity.ok(activityService.save(activity));
    }

    // update activity
    @PutMapping
    public ResponseEntity<Activity> updateActivity (@PathVariable(value = "id") int id, @RequestBody Activity updatedActivity) {
        return ResponseEntity.ok(activityService.update(id, updatedActivity));
    }

    // delete activity
    @DeleteMapping
    public ResponseEntity<Activity> deleteActivity (@PathVariable(value = "id") int id) {
        activityService.delete(id);
        return ResponseEntity.ok().build();
    }
}
