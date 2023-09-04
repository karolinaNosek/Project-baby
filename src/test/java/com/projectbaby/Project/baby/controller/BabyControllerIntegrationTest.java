package com.projectbaby.Project.baby.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projectbaby.Project.baby.model.dto.BabyDTO;
import com.projectbaby.Project.baby.model.entity.Baby;
import com.projectbaby.Project.baby.repository.BabyRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class BabyControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private BabyRepository babyRepository;

    @Test
    void getAllBabies_returnListOfBabies() throws Exception {

        //given
        Baby baby1 = new Baby();
        Baby baby2 = new Baby();

        babyRepository.saveAll(Arrays.asList(baby1, baby2));

        //when & then
        mockMvc.perform(get("/api/v1/babies")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    void create_returnCreatedBaby()throws Exception {

        //given
        BabyDTO babyDTO = new BabyDTO();
        babyDTO.setName("Jan");
        babyDTO.setWeightInGrams(8500);

        String babyJson = objectMapper.writeValueAsString(babyDTO);

        //when & then
        mockMvc.perform(post("/api/v1/babies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(babyJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Jan"))
                .andExpect(jsonPath("$.weightInGrams").value(8500));

    }

    @Test
    void getBabyById_returnBaby() throws Exception {

        //given
        Baby baby = new Baby();
        baby.setId(1);
        baby.setName("Maria");

        babyRepository.save(baby);

        //when & then
        mockMvc.perform(get("/api/v1/babies/{id}", baby.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(baby.getId()))
                .andExpect(jsonPath("$.name").value("Maria"));

    }

    @Test
    void update_returnUpdatedBaby() throws Exception {

        //given
        BabyDTO updatedBabyDTO = new BabyDTO();
        updatedBabyDTO.setName("Updated Name");
        updatedBabyDTO.setWeightInGrams(9000);
        updatedBabyDTO.setId(1);

        String updatedBabyJson = objectMapper.writeValueAsString(updatedBabyDTO);

        //when & then
        mockMvc.perform(put("/api/v1/babies/{id}", updatedBabyDTO.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedBabyJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(updatedBabyDTO.getId()))
                .andExpect(jsonPath("$.name").value("Updated Name"))
                .andExpect(jsonPath("$.weightInGrams").value(9000));

    }

    @Test
    void delete_shouldReturnOk() {

        //given

        //when

        //then

    }
}