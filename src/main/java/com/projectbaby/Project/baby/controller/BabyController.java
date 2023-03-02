package com.projectbaby.Project.baby.controller;

import com.projectbaby.Project.baby.model.dto.BabyDTO;
import com.projectbaby.Project.baby.model.entity.activity.Activity;
import com.projectbaby.Project.baby.service.ActivityService;
import com.projectbaby.Project.baby.model.entity.Baby;
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
    public ResponseEntity<List> getAllBabiesDTO() {
        return ResponseEntity.ok(babyService.getAllBabiesDTO());
    }
    @PostMapping
    public ResponseEntity<BabyDTO> createBaby(@RequestBody BabyDTO babyDTO) {
        return ResponseEntity.ok(babyService.save(BabyDTO));
    }
    @GetMapping("/{id}")
    public ResponseEntity<BabyDTO> getBabyById (@PathVariable(value = "id") int id) {
        return ResponseEntity.ok(babyService.getBabyById(id));
    }

    @PutMapping ("/{id}")
    public ResponseEntity<BabyDTO> update(@PathVariable(value = "id") int id, @RequestBody Baby updatedBaby){
        return ResponseEntity.ok(babyService.update(id, updatedBaby));
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> delete (@PathVariable(value = "id") int id) {
        babyService.delete(id);
        return ResponseEntity.ok().build();
    }
}
