package com.projectbaby.Project.baby.strategies;

import com.projectbaby.Project.baby.mapper.SleepMapper;
import com.projectbaby.Project.baby.model.dto.activity.ActivityDTO;
import com.projectbaby.Project.baby.model.dto.activity.BathDTO;
import com.projectbaby.Project.baby.model.dto.activity.SleepDTO;
import com.projectbaby.Project.baby.model.entity.activity.Activity;
import com.projectbaby.Project.baby.model.entity.activity.Bath;
import com.projectbaby.Project.baby.model.entity.activity.Sleep;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class SleepMappingService implements ActivityMappingStrategy {

    private SleepMapper sleepMapper;

    public SleepMappingService(SleepMapper sleepMapper) {
        this.sleepMapper = sleepMapper;
    }

    @Override
    public <T extends ActivityDTO> Activity mapToEntity(T activityDTO) {
        return sleepMapper.mapToSleep((SleepDTO) activityDTO);
    }

    @Override
    public <T extends Activity> ActivityDTO mapToDTO(T activity) {
        return sleepMapper.mapToSleepDto((Sleep) activity);
    }

    @Override
    public boolean match(Activity activity) {

        return activity instanceof Sleep;
    }

    @Override
    public boolean match(ActivityDTO activityDTO) {
        return activityDTO instanceof SleepDTO;
    }
}
