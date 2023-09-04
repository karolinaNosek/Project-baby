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
    public ResponseEntity<List<BabyDTO>> getAllBabies() {
        return ResponseEntity.ok(babyService.getAllBabies());
    }
    @PostMapping
    public ResponseEntity<BabyDTO> createBaby(@RequestBody BabyDTO babyDTO) {
        return ResponseEntity.ok(babyService.saveBaby(babyDTO));
    }
    @GetMapping("/{id}")
    public ResponseEntity<BabyDTO> getBabyById (@PathVariable(value = "id") Integer id) {
        return ResponseEntity.ok(babyService.getBabyById(id));
    }

    @PutMapping ("/{id}")
    public ResponseEntity<BabyDTO> updateBaby (@PathVariable(value = "id") Integer id, @RequestBody BabyDTO updatedBabyDTO) /* przekazuje obiekt typu Baby o nazwie updatedbabydto*/{
        return ResponseEntity.ok(babyService.updateBaby(id, updatedBabyDTO));
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deleteBaby (@PathVariable(value = "id") Integer id) {
        babyService.deleteBaby(id);
        return ResponseEntity.ok().build();
    }
}
