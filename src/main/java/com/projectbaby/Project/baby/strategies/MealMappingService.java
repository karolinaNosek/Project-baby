package com.projectbaby.Project.baby.strategies;

import com.projectbaby.Project.baby.mapper.MealMapper;
import com.projectbaby.Project.baby.model.dto.activity.ActivityDTO;
import com.projectbaby.Project.baby.model.dto.activity.BathDTO;
import com.projectbaby.Project.baby.model.dto.activity.MealDTO;
import com.projectbaby.Project.baby.model.entity.activity.Activity;
import com.projectbaby.Project.baby.model.entity.activity.Bath;
import com.projectbaby.Project.baby.model.entity.activity.Meal;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MealMappingService implements ActivityMappingStrategy {

    private MealMapper mealMapper;

    public MealMappingService(MealMapper mealMapper) {
        this.mealMapper = mealMapper;
    }

    @Override
    public <T extends ActivityDTO> Activity mapToEntity(T activityDTO) {
        return mealMapper.mapToMeal((MealDTO) activityDTO);
    }

    @Override
    public <T extends Activity> ActivityDTO mapToDTO(T activity) {
        return mealMapper.mapToMealDto((Meal) activity);
    }

    @Override
    public boolean match(Activity activity) {
        return activity instanceof Meal;
    }

    @Override
    public boolean match(ActivityDTO activityDTO) {
        return activityDTO instanceof MealDTO;
    }
}
