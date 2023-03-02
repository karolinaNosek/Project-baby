package com.projectbaby.Project.baby.service;

import com.projectbaby.Project.baby.model.dto.BabyDTO;
import com.projectbaby.Project.baby.model.entity.Baby;
import com.projectbaby.Project.baby.repository.BabyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BabyService {

    private BabyRepository babyRepository;

    public BabyService(BabyRepository babyRepository) {
        this.babyRepository = babyRepository;
    }

    public List<BabyDTO> getAllBabiesDTO() {
        List<Baby> babies = this.babyRepository.findAll();
        List<BabyDTO> babiesDTO = babies
        .stream()
        .map(this::mapToBabyDTO)
        .collect(Collectors.toList());
        return babiesDTO;
    }

    public BabyDTO getBabyById(int id) {
        BabyDTO babyById = babyRepository
                .findById((long) id)
                .orElseThrow(IllegalArgumentException::new);
        return babyById;
    }

    public BabyDTO save(Baby baby) {
        return babyRepository.save(baby);
    }

    public BabyDTO update(int id, Baby updatedBaby) {
        Baby babyById = babyRepository
                .findById((long) id)
                .orElseThrow(IllegalArgumentException::new);
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

    public BabyDTO mapToBabyDTO(Baby baby) {
        BabyDTO babyDTO = new BabyDTO();
        babyDTO.setId(baby.getId());
        babyDTO.setName(baby.getName());
        babyDTO.setDateOfBirth(baby.getDateOfBirth());
        babyDTO.setSex(baby.getSex());
        babyDTO.setHeight(baby.getHeight());
        babyDTO.setWeight(baby.getWeight());
        return babyDTO;
    }

    public Baby mapToBaby (BabyDTO babyDTO) {
        Baby baby = new Baby();
        baby.setId(babyDTO.getId());
        baby.setName(babyDTO.getName());
        baby.setDateOfBirth(babyDTO.getDateOfBirth());
        baby.setSex(babyDTO.getSex());
        baby.setHeight(babyDTO.getHeight());
        baby.setWeight(babyDTO.getWeight());
        return baby;
    }
}

