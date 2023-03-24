package com.projectbaby.Project.baby.strategies;

import com.projectbaby.Project.baby.mapper.BathMapper;
import com.projectbaby.Project.baby.model.dto.BabyDTO;
import com.projectbaby.Project.baby.model.dto.activity.ActivityDTO;
import com.projectbaby.Project.baby.model.dto.activity.BathDTO;
import com.projectbaby.Project.baby.model.entity.activity.Activity;
import com.projectbaby.Project.baby.model.entity.activity.Bath;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
public class BathMappingService implements ActivityMappingStrategy {

    private BathMapper bathmapper;
    public BathMappingService(BathMapper bathmapper) {
        this.bathmapper = bathmapper;
    }

    @Override
    public <T extends ActivityDTO> Activity mapToEntity(T activityDTO) {
        return bathmapper.mapToBath((BathDTO) activityDTO);
    }

    @Override
    public <T extends Activity> ActivityDTO mapToDTO(T activity) {
        return bathmapper.mapToBathDTO((Bath) activity);
    }
}
