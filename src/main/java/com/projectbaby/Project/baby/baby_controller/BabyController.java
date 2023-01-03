package com.projectbaby.Project.baby.baby_controller;

import com.projectbaby.Project.baby.model.Baby;
import com.projectbaby.Project.baby.service.BabyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/v1")
public class BabyController {

    @Autowired
    BabyService babyService;

    //create get all babies api
    @GetMapping("/babies")
    public List<Baby> getAllBabies() {
        return babyService.getAllBabies();
    }

    //create baby
    @PostMapping("/babies")
    public Baby createBaby(@RequestBody Baby baby) {
        return babyService.save(baby);
    }

    //get baby by id
    @GetMapping("/babies/{id}")
    public Baby getBabyById (@PathVariable(value = "id") int id) {
        return babyService.getBabyById(id);
    }

    //update baby
    @PutMapping ("/babies/{id}")
    public Baby update(@PathVariable(value = "id") int id, @RequestBody Baby updatedBaby){
        Baby babyById = babyService.getBabyById(id);
        babyById.setName(updatedBaby.getName());
        babyById.setSex(updatedBaby.getSex());
        babyById.setHeight(updatedBaby.getHeight());
        babyById.setWeight(updatedBaby.getWeight());
        return babyService.update(babyById);
    }

    //delete baby by name
    @DeleteMapping ("/babies/{id}")
    public Baby delete (@PathVariable(value = "id") int id) {
        return babyService.delete(id);
    }
}
