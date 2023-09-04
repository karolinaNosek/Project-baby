package com.projectbaby.Project.baby.testutils;

import com.projectbaby.Project.baby.model.dto.activity.BathDTO;
import com.projectbaby.Project.baby.model.dto.activity.SleepDTO;
import com.projectbaby.Project.baby.model.dto.activity.WalkDTO;
import com.projectbaby.Project.baby.model.entity.activity.Meal;
import com.projectbaby.Project.baby.model.entity.activity.Sleep;
import com.projectbaby.Project.baby.model.entity.activity.Walk;

import java.time.LocalTime;

public class TestActivityCreator {
    public static SleepDTO createNapDTO (String nap) {
        SleepDTO sleepDTO = new SleepDTO();
        sleepDTO.setNap(nap);
        return sleepDTO;
    }

    public static Sleep createNap(String nap) {
        Sleep sleep = new Sleep();
        sleep.setNap(nap);
        return sleep;
    }

    public static Walk updateWalkByActivityEndTime (String time) {
        Walk walk = new Walk();
        walk.setPlayground(time);
        return walk;
    }

    public static WalkDTO updateWalkDTOByActivityEndTime (String time) {
        WalkDTO walkDTO = new WalkDTO();
        walkDTO.setPlayground(time);
        return walkDTO;
    }

    public static Meal deleteMealById (Integer id) {
        Meal meal = new Meal();
        meal.setId(id);
        return meal;
    }
}
