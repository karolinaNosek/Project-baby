package com.projectbaby.Project.baby.mapper;

import com.projectbaby.Project.baby.activity.Meal;
import com.projectbaby.Project.baby.dto.MealDTO;
import org.mapstruct.Mapper;

@Mapper
public interface MealMapper {
    MealDTO mapToMealDto (Meal meal);
    Meal mapToMeal (MealDTO mealDTO);
}
