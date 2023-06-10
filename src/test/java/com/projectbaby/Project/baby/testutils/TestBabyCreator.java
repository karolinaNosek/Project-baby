package com.projectbaby.Project.baby.testutils;

import com.projectbaby.Project.baby.exception.ResourceNotFoundException;
import com.projectbaby.Project.baby.model.dto.BabyDTO;
import com.projectbaby.Project.baby.model.entity.Baby;

public class TestBabyCreator {
    public static BabyDTO createBabyDTOWithName (String name) {
        BabyDTO babyDTO = new BabyDTO();
        babyDTO.setName(name);
        return babyDTO;
    }

    public static Baby createBabyWithName (String name) {
        Baby baby = new Baby();
        baby.setName(name);
        return baby;
    }

    public static BabyDTO updateBabyDTOByWeight (int weight) {
        BabyDTO updatedBabyDTOByWeight = new BabyDTO();
        updatedBabyDTOByWeight.setWeightInGrams(weight);
        return updatedBabyDTOByWeight;
    }

    public static Baby updateBabyByWeight (int weight) {
        Baby updatedBabyByWeight = new Baby();
        updatedBabyByWeight.setWeightInGrams(weight);
        return updatedBabyByWeight;
    }

    public static void exception () throws ResourceNotFoundException {
        throw new ResourceNotFoundException("Baby not found!");
    }

}
