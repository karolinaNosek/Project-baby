package com.projectbaby.Project.baby.strategies;

import com.projectbaby.Project.baby.mapper.WalkMapper;
import com.projectbaby.Project.baby.model.dto.activity.ActivityDTO;
import com.projectbaby.Project.baby.model.dto.activity.BathDTO;
import com.projectbaby.Project.baby.model.dto.activity.WalkDTO;
import com.projectbaby.Project.baby.model.entity.activity.Activity;
import com.projectbaby.Project.baby.model.entity.activity.Bath;
import com.projectbaby.Project.baby.model.entity.activity.Walk;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class WalkMappingService implements ActivityMappingStrategy {

    private WalkMapper walkMapper;

    public WalkMappingService(WalkMapper walkMapper) {
        this.walkMapper = walkMapper;
    }

    @Override
    public <T extends ActivityDTO> Activity mapToEntity(T activityDTO) {
        return walkMapper.mapToWalk((WalkDTO) activityDTO);
    }

    @Override
    public <T extends Activity> ActivityDTO mapToDTO(T activity) {
        return walkMapper.mapToWalkDto((Walk) activity);
    }

    @Override
    public boolean match(Activity activity) {
        return activity instanceof Walk;
    }

    @Override
    public boolean match(ActivityDTO activityDTO) {
        return activityDTO instanceof WalkDTO;
    }
}
