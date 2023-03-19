package com.projectbaby.Project.baby.strategies;

import com.projectbaby.Project.baby.model.dto.activity.BathDTO;
import com.projectbaby.Project.baby.model.dto.activity.MealDTO;
import com.projectbaby.Project.baby.model.entity.activity.Bath;
import com.projectbaby.Project.baby.model.entity.activity.Meal;
import org.mapstruct.Mapper;

@Mapper
public class MealMappingService implements ActivityMappingStrategy {

    @Override
    MealDTO mapToDTO (Meal meal);

    @Override
    Meal mapToEntity (MealDTO mealDTO);
}
