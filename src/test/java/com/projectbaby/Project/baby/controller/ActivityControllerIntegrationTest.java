package com.projectbaby.Project.baby.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projectbaby.Project.baby.model.dto.activity.ActivityDTO;
import com.projectbaby.Project.baby.model.dto.activity.SleepDTO;
import com.projectbaby.Project.baby.model.dto.activity.WalkDTO;
import com.projectbaby.Project.baby.model.entity.activity.*;
import com.projectbaby.Project.baby.repository.ActivityRepository;
import com.projectbaby.Project.baby.service.ActivityService;
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ActivityControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private ActivityService activityService;

    @Test
    void getAllActivities_shouldReturnListOfActivities() throws Exception {

        // given

        Meal meal = new Meal();
        Walk walk = new Walk();
        Bath bath = new Bath();


        List<Activity> activityList = activityRepository.saveAll(Arrays.asList(meal, walk, bath));

        // when & then
        mockMvc.perform(get("/api/v1/activities")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(activityList)));

    }


    @Test
    void add_shouldReturnAddedActivity() throws Exception {

        //given
        SleepDTO sleepActivityDTO = new SleepDTO();
        sleepActivityDTO.setActivityName("morning nap");

        when(activityService.saveActivity(any(ActivityDTO.class))).thenReturn(sleepActivityDTO);

        //when & then
        mockMvc.perform(post("/api/v1/activities")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(sleepActivityDTO)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(sleepActivityDTO)));

    }

    @Test
    void update_shouldReturnUpdatedActivity() throws Exception {

        //given
        Integer activityId = 1;
        Walk updatedWalkActivity = new Walk();
        updatedWalkActivity.setActivityName("park with dad and dog");

        when(activityRepository.findById(eq(activityId))).thenReturn(Optional.of(updatedWalkActivity));
//        when(activityService.updateActivity(eq(activityId), any(ActivityDTO.class))).thenReturn(updatedWalkActivity);

        //when & then
        mockMvc.perform(put("/api/v1/activities/{id}", activityId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedWalkActivity)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(updatedWalkActivity)));

    }

    @Test
    void delete_shouldReturnOk() throws Exception {

        // given
        Integer activityId = 1;
        Walk deletedWalkActivity = new Walk();
        deletedWalkActivity.setActivityName("deleted walk");

        when(activityRepository.findById(eq(activityId))).thenReturn(Optional.of(deletedWalkActivity));
        doNothing().when(activityRepository).deleteById(eq(activityId));

        // when & then
        mockMvc.perform(delete("/api/v1/activities/{id}", activityId))
                .andExpect(status().isOk());

    }
}