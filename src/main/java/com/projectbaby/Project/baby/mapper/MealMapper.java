package com.projectbaby.Project.baby.mapper;

import com.projectbaby.Project.baby.model.entity.activity.Meal;
import com.projectbaby.Project.baby.model.dto.activity.MealDTO;
import org.mapstruct.Mapper;

@Mapper
public interface MealMapper {
    MealDTO mapToMealDto (Meal meal);
    Meal mapToMeal (MealDTO mealDTO);
}
