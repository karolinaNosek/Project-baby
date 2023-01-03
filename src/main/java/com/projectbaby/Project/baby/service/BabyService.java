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

    @Autowired
    BabyController babyController;

    public List<Baby> getAllBabies(){
        List<Baby> allBabies = babyController.getAllBabies();
        return allBabies;
    }

    public Baby getBabyById (int id) {
        Baby babyById = babyController.getBabyById(id);
        return babyById;
    }

    public Baby save(Baby baby) {
        return save(baby);
    }

    public Baby update (Baby baby) {
        baby.getName();
        baby.getSex();
        baby.getHeight();
        baby.getWeight();
        return update(baby);
    }

    public Baby delete (int id){
        return delete(id);
    }
}
