package com.projectbaby.Project.baby.service;

import com.projectbaby.Project.baby.exception.ResourceNotFoundException;
import com.projectbaby.Project.baby.mapper.BabyMapper;
import com.projectbaby.Project.baby.model.dto.BabyDTO;
import com.projectbaby.Project.baby.model.entity.Baby;
import com.projectbaby.Project.baby.repository.BabyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.projectbaby.Project.baby.testutils.TestBabyCreator;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@Import(BabyService.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class BabyServiceUnitTest {

    @MockBean
    private BabyRepository babyRepository;
    @MockBean
    private BabyMapper babyMapper;
    @Autowired
    private BabyService babyService;


    @Test
    void shouldBabiesEquals () {

        //given
        BabyDTO babyDTO = TestBabyCreator.createBabyDTOWithName("Aleks");
        Baby mappedBaby = TestBabyCreator.createBabyWithName("Aleks");
        when(babyMapper.mapToBaby(any())).thenReturn(mappedBaby);
        when(babyRepository.save(any())).thenReturn(mappedBaby);
        when(babyMapper.mapToBabyDTO(any())).thenReturn(babyDTO);

        //when
        BabyDTO savedBabyDTO = babyService.saveBaby(babyDTO);

        //then
        assertEquals(babyDTO.getName(), savedBabyDTO.getName());
    }

    @Test
    void shouldBabyDTO1BeUpdatedByWeight () {

       //given
        BabyDTO babyDTO1 = TestBabyCreator.updateBabyDTOByWeight(6500);
        Baby mappedBaby = TestBabyCreator.updateBabyByWeight(6500);
        when(babyMapper.mapToBaby(any())).thenReturn(mappedBaby);
        when(babyRepository.save(any())).thenReturn(mappedBaby);
        when(babyMapper.mapToBabyDTO(any())).thenReturn(babyDTO1);
        when(babyRepository.findById(any())).thenReturn(Optional.of(mappedBaby));

        //when
        BabyDTO updatedBabyDTO = babyService.updateBaby(1, babyDTO1);

        //then
        assertEquals(babyDTO1.getWeightInGrams(), updatedBabyDTO.getWeightInGrams());
    }


    @Test
    void shouldReturnMessage_ResourceNotFoundException () {

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

    @Test
    void deleteBaby_verifyIfBabyWasDeleted (){

        //given
        Integer id = 1;
        when(babyRepository.existsById(id)).thenReturn(true);

        //when
        babyService.deleteBaby(id);

        //then
        verify(babyRepository, times(1)).deleteById(id);

    }
}
