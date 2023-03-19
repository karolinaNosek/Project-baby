package com.projectbaby.Project.baby.strategies;

import com.projectbaby.Project.baby.model.dto.activity.BathDTO;
import com.projectbaby.Project.baby.model.dto.activity.SleepDTO;
import com.projectbaby.Project.baby.model.entity.activity.Bath;
import com.projectbaby.Project.baby.model.entity.activity.Sleep;
import org.mapstruct.Mapper;

@Mapper
public class SleepMappingService implements ActivityMappingStrategy {

    @Override
    SleepDTO mapToDTO (Sleep sleep);

    @Override
    Sleep mapToEntity (SleepDTO sleepDTO);

}
