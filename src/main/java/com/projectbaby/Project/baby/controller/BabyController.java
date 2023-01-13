package com.projectbaby.Project.baby.controller;

import com.projectbaby.Project.baby.model.Baby;
import com.projectbaby.Project.baby.service.BabyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/v1/babies")
public class BabyController {

    private BabyService babyService;

    public BabyController (BabyService babyService){
        this.babyService = babyService;
    }

    @GetMapping("/")
    public ResponseEntity<List> getAllBabies() {
        return ResponseEntity.ok(babyService.getAllBabies());
    }

    //create baby
    @PostMapping("/")
    public ResponseEntity<Baby> createBaby(@RequestBody Baby baby) {
        return ResponseEntity.ok(babyService.save(baby));
    }

    //get baby by id
    @GetMapping("/{id}")
    public ResponseEntity<Baby> getBabyById (@PathVariable(value = "id") int id) {
        return ResponseEntity.ok(babyService.getBabyById(id));
    }

    //update baby
    @PutMapping ("/{id}")
    public ResponseEntity<Baby> update(@PathVariable(value = "id") int id, @RequestBody Baby updatedBaby){
        return ResponseEntity.ok(babyService.update(id, updatedBaby));
    }

    //delete baby by id
    @DeleteMapping ("/{id}")
    public ResponseEntity<Baby> delete (@PathVariable(value = "id") int id) {
        babyService.delete(id);
        return ResponseEntity.ok().build();
    }
}
