package com.projectbaby.Project.baby.service;

import com.projectbaby.Project.baby.mapper.BabyMapper;
import com.projectbaby.Project.baby.model.dto.BabyDTO;
import com.projectbaby.Project.baby.model.entity.Baby;
import com.projectbaby.Project.baby.repository.BabyRepository;
import com.projectbaby.Project.baby.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BabyService {

    private BabyRepository babyRepository;
    private BabyMapper babyMapper;

    public BabyService(BabyRepository babyRepository, BabyMapper babyMapper) {
        this.babyRepository = babyRepository;
        this.babyMapper = babyMapper;
    }
    public List<BabyDTO> getAllBabies() {
        List<Baby> babies = this.babyRepository.findAll();
        List<BabyDTO> babiesDTO = babies
        .stream()
        .map(babyMapper::mapToBabyDTO)
        .collect(Collectors.toList());
        return babiesDTO;
    }

    public BabyDTO getBabyById(Integer id) {
        Baby babyById = babyRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Activity not found for this id: " + id ));
        BabyDTO babyDTO = babyMapper.mapToBabyDTO(babyById);
        return babyDTO;
    }

    public BabyDTO saveBaby (BabyDTO babyDTO) {
        Baby baby = babyMapper.mapToBaby(babyDTO);
        Baby savedBaby = babyRepository.save(baby);
        BabyDTO savedBabyDTO = babyMapper.mapToBabyDTO(savedBaby);
        return savedBabyDTO;
    }

    public BabyDTO updateBaby (Integer id, BabyDTO updatedBabyDTO) {
       Baby existingBaby = babyRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Baby not found for this id: " + id ));
        existingBaby.setName(updatedBabyDTO.getName());
        existingBaby.setSex(updatedBabyDTO.getSex());
        existingBaby.setHeightInCentimeters(updatedBabyDTO.getHeightInCentimeters());
        existingBaby.setWeightInGrams(updatedBabyDTO.getWeightInGrams());
        babyRepository.save(existingBaby);
        BabyDTO existingBabyDTO = babyMapper.mapToBabyDTO(existingBaby);
        return existingBabyDTO;
    }

    public void deleteBaby (Integer id) {
        if (babyRepository.existsById(id)) {
            babyRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException();
        }
    }

}

