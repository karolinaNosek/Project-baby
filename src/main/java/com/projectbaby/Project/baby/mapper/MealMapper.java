package com.projectbaby.Project.baby.mapper;

import com.projectbaby.Project.baby.model.entity.activity.Meal;
import com.projectbaby.Project.baby.model.dto.activity.MealDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {BabyMapper.class} )
public interface MealMapper {
    @Mapping(target = "baby", ignore = true)
    MealDTO mapToMealDto (Meal meal);
    @Mapping(target = "baby", ignore = true)
    Meal mapToMeal (MealDTO mealDTO);
}
