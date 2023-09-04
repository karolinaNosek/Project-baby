package com.projectbaby.Project.baby.service;

import com.projectbaby.Project.baby.model.dto.BabyDTO;
import com.projectbaby.Project.baby.model.dto.activity.ActivityDTO;
import com.projectbaby.Project.baby.model.dto.activity.SleepDTO;
import com.projectbaby.Project.baby.model.dto.activity.WalkDTO;
import com.projectbaby.Project.baby.model.entity.Baby;
import com.projectbaby.Project.baby.model.entity.activity.Activity;
import com.projectbaby.Project.baby.model.entity.activity.Meal;
import com.projectbaby.Project.baby.model.entity.activity.Sleep;
import com.projectbaby.Project.baby.model.entity.activity.Walk;
import com.projectbaby.Project.baby.repository.ActivityRepository;
import com.projectbaby.Project.baby.strategies.ActivityMappingStrategy;
import com.projectbaby.Project.baby.strategies.SleepMappingService;
import com.projectbaby.Project.baby.testutils.TestActivityCreator;
import com.projectbaby.Project.baby.testutils.TestBabyCreator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@Import(ActivityService.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ActivityServiceUnitTest {

    @MockBean
    ActivityRepository activityRepository;

    @MockBean
    ActivityMappingStrategy activityMappingStrategy;

    @Autowired
    ActivityService activityService;


    @Test
    void shouldNapActivitiesEquals() {

        //given
        SleepDTO sleepDTO = TestActivityCreator.createNapDTO("afternoon nap");
        Sleep mappedSleep = TestActivityCreator.createNap("morning nap");
        when(activityMappingStrategy.mapToEntity(any())).thenReturn(mappedSleep);
        when(activityRepository.save(any())).thenReturn(mappedSleep);
        when(activityMappingStrategy.mapToDTO(any())).thenReturn(sleepDTO);
        when(activityMappingStrategy.match(any(ActivityDTO.class))).thenReturn(true);
        when(activityMappingStrategy.match(any(Activity.class))).thenReturn(true);


        //when
        SleepDTO savedSleepDTO = (SleepDTO) activityService.saveActivity(sleepDTO);

        //then
        assertEquals(sleepDTO.getNap(), savedSleepDTO.getNap());


    }

    @Test
    void shouldPlaygroundActivityBeUpdated() {

        //given
        WalkDTO walkDTO = TestActivityCreator.updateWalkDTOByActivityEndTime("16:05");
        Walk mappedWalk = TestActivityCreator.updateWalkByActivityEndTime("16:05");
        when(activityMappingStrategy.mapToEntity(any())).thenReturn(mappedWalk);
        when(activityRepository.save(any())).thenReturn(mappedWalk);
        when(activityMappingStrategy.mapToDTO(any())).thenReturn(walkDTO);
        when(activityMappingStrategy.match(any(ActivityDTO.class))).thenReturn(true);
        when(activityMappingStrategy.match(any(Activity.class))).thenReturn(true);

        //when
        WalkDTO savedWalkDTO = (WalkDTO) activityService.saveActivity(walkDTO);

        //then
        assertEquals(walkDTO.getPlayground(), savedWalkDTO.getPlayground());

    }

    @Test
    void shouldDeleteMealActivity() {

        //given

        //when

        //then

    }
}