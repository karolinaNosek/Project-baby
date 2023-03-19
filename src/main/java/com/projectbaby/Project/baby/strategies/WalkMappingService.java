package com.projectbaby.Project.baby.strategies;

import com.projectbaby.Project.baby.model.dto.activity.BathDTO;
import com.projectbaby.Project.baby.model.dto.activity.WalkDTO;
import com.projectbaby.Project.baby.model.entity.activity.Bath;
import com.projectbaby.Project.baby.model.entity.activity.Walk;
import org.mapstruct.Mapper;

@Mapper
public class WalkMappingService implements ActivityMappingStrategy {

    @Override
    WalkDTO mapToDTO (Walk walk);

    @Override
    Walk mapToEntity (WalkDTO walkDTO);

}
