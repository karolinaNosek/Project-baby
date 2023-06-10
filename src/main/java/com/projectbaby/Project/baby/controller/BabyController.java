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
    public ResponseEntity<List<BabyDTO>> getAllBabiesDTO() {
        return ResponseEntity.ok(babyService.getAllBabiesDTO());
    }
    @PostMapping
    public ResponseEntity<BabyDTO> createBabyDTO(@RequestBody BabyDTO babyDTO) {
        return ResponseEntity.ok(babyService.saveBabyDTO(babyDTO));
    }
    @GetMapping("/{id}")
    public ResponseEntity<BabyDTO> getBabyDTOById (@PathVariable(value = "id") Integer id) {
        return ResponseEntity.ok(babyService.getBabyDTOById(id));
    }

    @PutMapping ("/{id}")
    public ResponseEntity<BabyDTO> updateBabyDTO (@PathVariable(value = "id") Integer id, @RequestBody BabyDTO updatedBabyDTO) /* przekazuje obiekt typu Baby o nazwie updatedbabydto*/{
        return ResponseEntity.ok(babyService.updateBabyDTO(id, updatedBabyDTO));
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deleteBaby (@PathVariable(value = "id") Integer id) {
        babyService.deleteBaby(id);
        return ResponseEntity.ok().build();
    }
}
