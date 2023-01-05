package com.projectbaby.Project.baby.baby_controller;

import com.projectbaby.Project.baby.model.Baby;
import com.projectbaby.Project.baby.service.BabyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/v1")
public class BabyController {

    @Autowired
    BabyService babyService;

    //create get all babies api
    @GetMapping("/babies")
    public ResponseEntity<List> getAllBabies() {
        return ResponseEntity.ok(babyService.getAllBabies());
    }

    //create baby
    @PostMapping("/babies")
    public ResponseEntity<Baby> createBaby(@RequestBody Baby baby) {
        return ResponseEntity.ok(babyService.save(baby));
    }

    //get baby by id
    @GetMapping("/babies/{id}")
    public ResponseEntity<Baby> getBabyById (@PathVariable(value = "id") int id) {
        return ResponseEntity.ok(babyService.getBabyById(id));
    }

    //update baby
    @PutMapping ("/babies/{id}")
    public ResponseEntity<Baby> update(@PathVariable(value = "id") int id, @RequestBody Baby updatedBaby){
        return ResponseEntity.ok(babyService.update(id, updatedBaby));
    }

    //delete baby by name
    @DeleteMapping ("/babies/{id}")
    public ResponseEntity<Baby> delete (@PathVariable(value = "id") int id) {
        return ResponseEntity.ok(babyService.delete(id));
    }
}
