package com.projectbaby.Project.baby.service;

import com.projectbaby.Project.baby.exception.ResourceNotFoundException;
import com.projectbaby.Project.baby.mapper.BabyMapper;
import com.projectbaby.Project.baby.model.dto.BabyDTO;
import com.projectbaby.Project.baby.model.entity.Baby;
import com.projectbaby.Project.baby.repository.BabyRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.projectbaby.Project.baby.testutils.TestBabyCreator;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@Import(BabyService.class)
class BabyServiceTest {

    @MockBean
    private BabyRepository babyRepository;
    @MockBean
    private BabyMapper babyMapper;
    @Autowired
    private BabyService babyService;


    @Test
    void verifyIfBabiesDTOEquals () {

        //given
        BabyDTO babyDTO = TestBabyCreator.createBabyDTOWithName("Aleks");
        Baby mappedBaby = TestBabyCreator.createBabyWithName("Aleks");
        when(babyMapper.mapToBaby(any())).thenReturn(mappedBaby);
        when(babyRepository.save(any())).thenReturn(mappedBaby);
        when(babyMapper.mapToBabyDTO(any())).thenReturn(babyDTO);

        //when
        BabyDTO savedBabyDTO = babyService.saveBabyDTO(babyDTO);

        //then
        assertEquals(babyDTO.getName(), savedBabyDTO.getName());
    }

    @Test
    void verifyIfBabyDTO1WasUpdatedByWeight () {

       //given
        BabyDTO babyDTO1 = TestBabyCreator.updateBabyDTOByWeight(6500);
        Baby mappedBaby = TestBabyCreator.updateBabyByWeight(6500);
        when(babyMapper.mapToBaby(any())).thenReturn(mappedBaby);
        when(babyRepository.save(any())).thenReturn(mappedBaby);
        when(babyMapper.mapToBabyDTO(any())).thenReturn(babyDTO1);

        //when
        BabyDTO updatedBabyDTO = babyService.updateBabyDTO(15, babyDTO1);

        //then
        assertEquals(babyDTO1.getWeightInGrams(), updatedBabyDTO.getWeightInGrams());
    }

    @Test
    void verifyIfBabyDTOWasDeletedById (){

    }

    @Test
    void verifyMessage_ResourceNotFoundException () {

        //given
        String expectedMessage = "Baby not found!";

        //when
        String actualMessage = null;
        try {
            TestBabyCreator.exception();
        } catch (ResourceNotFoundException msg) {
            actualMessage = msg.getMessage();
        }

        //then
        assertEquals(expectedMessage, actualMessage);

    }
}
