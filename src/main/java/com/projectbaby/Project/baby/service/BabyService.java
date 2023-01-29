package com.projectbaby.Project.baby.service;

import com.projectbaby.Project.baby.model.Baby;
import com.projectbaby.Project.baby.repository.BabyRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BabyService {

    private BabyRepository babyRepository;

    public BabyService(BabyRepository babyRepository) {
        this.babyRepository = babyRepository;
    }

    public List<Baby> getAllBabies() {
        List<Baby> allBabies = babyRepository.findAll();
        return allBabies;
    }

    public Baby getBabyById(int id) {
        Baby babyById = babyRepository.findById((long) id).orElseThrow(() -> new IllegalArgumentException());
        return babyById;
    }

    public Baby save(Baby baby) {
        return babyRepository.save(baby);
    }

    public Baby update(int id, Baby updatedBaby) {
        Baby babyById = babyRepository.findById((long) id).orElseThrow(() -> new IllegalArgumentException());
        babyById.setName(updatedBaby.getName());
        babyById.setSex(updatedBaby.getSex());
        babyById.setHeight(updatedBaby.getHeight());
        babyById.setWeight(updatedBaby.getWeight());
        return babyRepository.save(babyById);
    }

    public void delete(int id) {
        if (babyRepository.existsById((long) id)) {
            babyRepository.deleteById((long) id);
        } else {
            throw new IllegalArgumentException();
        }
    }
}
