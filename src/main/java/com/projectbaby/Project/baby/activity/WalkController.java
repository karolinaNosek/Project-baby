package com.projectbaby.Project.baby.activity;

import com.projectbaby.Project.baby.repository.BabyRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/activities")
public class WalkController {

    private WalkService walkService;
    private BabyRepository babyRepository;

    public WalkController(WalkService walkService, BabyRepository babyRepository) {
        this.walkService = walkService;
        this.babyRepository = babyRepository;
    }


    @GetMapping
    public ResponseEntity<List> walkActivities (){
        return ResponseEntity.ok(walkService.activities());
    }

    // add activity
    @PostMapping
    public ResponseEntity<Activity> addWalkActivity (@RequestBody Walk walk) {
        return ResponseEntity.ok(walkService.save(walk));
    }

    // update activity
    @PutMapping
    public ResponseEntity<Activity> updateWalkActivity (@PathVariable(value = "id") int id, @RequestBody Walk updatedWalkActivity) {
        return ResponseEntity.ok(walkService.update(id, updatedWalkActivity));
    }

    // delete activity
    @DeleteMapping
    public ResponseEntity<Activity> deleteWalkActivity (@PathVariable(value = "id") int id) {
        walkService.delete(id);
        return ResponseEntity.ok().build();
    }
}
