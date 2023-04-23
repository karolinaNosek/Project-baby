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
    public List<BabyDTO> getAllBabiesDTO() {
        List<Baby> babies = this.babyRepository.findAll();
        List<BabyDTO> babiesDTO = babies
        .stream()
        .map(babyMapper::mapToBabyDTO)
        .collect(Collectors.toList());
        return babiesDTO;
    }

    public BabyDTO getBabyById(Integer id) {
        Baby babyById = babyRepository
                .findById((long) id)
                .orElseThrow(() -> new ResourceNotFoundException("Activity not found for this id: " + id ));
        BabyDTO babyDTO = babyMapper.mapToBabyDTO(babyById);
        return babyDTO;
    }

    public BabyDTO save(BabyDTO babyDTO) {
        Baby baby = babyMapper.mapToBaby(babyDTO);
        babyRepository.save(baby);
        BabyDTO babyDTO1 = babyMapper.mapToBabyDTO(baby);
        return babyDTO1;
    }

    public BabyDTO update(int id, BabyDTO updatedBabyDTO) {
        Baby babyById = babyMapper.mapToBaby(updatedBabyDTO);
       babyRepository
                .findById((long) id)
                .orElseThrow(() -> new ResourceNotFoundException("Baby not found for this id: " + id ));
        babyById.setName(updatedBabyDTO.getName());
        babyById.setSex(updatedBabyDTO.getSex());
        babyById.setHeight(updatedBabyDTO.getHeight());
        babyById.setWeight(updatedBabyDTO.getWeight());
        babyRepository.save(babyById);
        BabyDTO babyDTO2 = babyMapper.mapToBabyDTO(babyById);
        return babyDTO2;
    }

    public void delete(int id) {
        if (babyRepository.existsById((long) id)) {
            babyRepository.deleteById((long) id);
        } else {
            throw new IllegalArgumentException();
        }
    }

}

