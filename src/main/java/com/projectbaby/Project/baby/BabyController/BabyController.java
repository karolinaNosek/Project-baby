package com.projectbaby.Project.baby.BabyController;

import com.projectbaby.Project.baby.Model.Baby;
import com.projectbaby.Project.baby.Repository.BabyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/api/v1")
public class BabyController {

    @Autowired
    private BabyRepository babyRepository;

    //create get all babies api
    @GetMapping("/babies")
    public List<Baby> getAllBabies() {
        return babyRepository.findAll();
    }

    //create baby
    @PostMapping("/babies")
    public Baby createBaby(@RequestBody Baby baby) {
        return babyRepository.save(baby);
    }

    //get baby by id
    @GetMapping("/babies/{id}")
    public ResponseEntity<Baby> getBabyByName (@PathVariable(value = "id") int id) {
        Baby baby = babyRepository.findById(id).orElseThrow(()->new IllegalArgumentException());
        return ResponseEntity.ok().body(baby);
    }

    //update baby
    @PutMapping ("/babies/{id}")
    public ResponseEntity<Baby> updateBaby (@PathVariable(value = "id") int id, @RequestBody Baby babyDetails) {
        Baby baby = babyRepository.getReferenceById(id);
        baby.setName(babyDetails.getName());
        baby.setSex(babyDetails.getSex());
        baby.setHeight(babyDetails.getHeight());
        baby.setWeight(babyDetails.getWeight());
        babyRepository.save(baby);
        return ResponseEntity.ok().body(baby);
    }

    //delete baby by name
    @DeleteMapping ("/babies/{id}")
    public ResponseEntity<?> deleteBaby (@PathVariable(value = "id") int id, @RequestBody Baby babyDetails) {
        babyRepository.findById(id);
        babyRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }


    

}
