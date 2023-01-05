package com.projectbaby.Project.baby.service;

import com.projectbaby.Project.baby.baby_controller.BabyController;
import com.projectbaby.Project.baby.model.Baby;
import com.projectbaby.Project.baby.repository.BabyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BabyService {

    @Autowired
    BabyRepository babyRepository;

    public List<Baby> getAllBabies(){
        List<Baby> allBabies = babyRepository.findAll();
        return allBabies;
    }

    public Baby getBabyById (int id) {
        Baby babyById = babyRepository.findById(id).orElseThrow(()->new IllegalArgumentException());
        return babyById;
    }

    public Baby save(Baby baby) {
        return save(baby);
    }

    public Baby update (int id, Baby updatedBaby) {
        Baby babyById = babyRepository.findById(id).orElseThrow(()->new IllegalArgumentException());
        babyById.setName(updatedBaby.getName());
        babyById.setSex(updatedBaby.getSex());
        babyById.setHeight(updatedBaby.getHeight());
        babyById.setWeight(updatedBaby.getWeight());
        return save(updatedBaby);
    }

    public Baby delete (int id) {
        return delete(id);
    }
}
