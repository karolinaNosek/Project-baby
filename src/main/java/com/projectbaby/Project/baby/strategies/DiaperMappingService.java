package com.projectbaby.Project.baby.strategies;

import com.projectbaby.Project.baby.mapper.DiaperMapper;
import com.projectbaby.Project.baby.model.dto.activity.ActivityDTO;
import com.projectbaby.Project.baby.model.dto.activity.BathDTO;
import com.projectbaby.Project.baby.model.dto.activity.DiaperDTO;
import com.projectbaby.Project.baby.model.entity.activity.Activity;
import com.projectbaby.Project.baby.model.entity.activity.Bath;
import com.projectbaby.Project.baby.model.entity.activity.Diaper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
public class DiaperMappingService implements ActivityMappingStrategy {

    private DiaperMapper diaperMapper;
    public DiaperMappingService(DiaperMapper diaperMapper) {
        this.diaperMapper = diaperMapper;
    }
    @Override
    public <T extends ActivityDTO> Activity mapToEntity(T activityDTO) {
        return diaperMapper.mapToDiaper((DiaperDTO) activityDTO);
    }

    @Override
    public <T extends Activity> ActivityDTO mapToDTO(T activity) {
        return diaperMapper.mapToDiaperDto((Diaper) activity);
    }
}
