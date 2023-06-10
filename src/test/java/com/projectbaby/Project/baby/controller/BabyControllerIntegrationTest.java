package com.projectbaby.Project.baby.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projectbaby.Project.baby.model.dto.BabyDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@AutoConfigureMockMvc
@ActiveProfiles("Test")
class BabyControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAllBabiesDTO_returnListOfBabiesDTO() throws Exception {
        mockMvc.perform(get("/api/v1/babies")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    void create_returnCreatedBabyDTO() throws Exception {
        BabyDTO babyDTO = new BabyDTO();
        babyDTO.setName("Jan");
        babyDTO.setWeightInGrams(8500);

        String babyJson = objectMapper.writeValueAsString(babyDTO);

        mockMvc.perform(post("/api/v1/babies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(babyJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Jan"))
                .andExpect(jsonPath("$.weight").value(8500));

    }

    @Test
    void getBabyById_returnBabyDTO() throws Exception {
        int babyId = 1;

        mockMvc.perform(get("/api/v1/babies/{id}", babyId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(babyId))
                .andExpect(jsonPath("$.name").value("Jan"))
                .andExpect(jsonPath("$.age").value(1));

    }

    @Test
    void update_returnUpdatedBabyDTO() throws Exception {
        int babyId = 1;

        BabyDTO updatedBabyDTO = new BabyDTO();
        updatedBabyDTO.setName("Updated Name");
        updatedBabyDTO.setWeightInGrams(9000);

        String updatedBabyJson = objectMapper.writeValueAsString(updatedBabyDTO);

        mockMvc.perform(put("/api/v1/babies/{id}", babyId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedBabyJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(babyId))
                .andExpect(jsonPath("$.name").value("Updated Name"))
                .andExpect(jsonPath("$.weight").value(9000));

    }

    @Test
    void delete_returnOk() throws Exception {
        int babyId = 1;

        mockMvc.perform(delete("/api/v1/babies/{id}", babyId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }
}