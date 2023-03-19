package com.projectbaby.Project.baby.strategies;

import com.projectbaby.Project.baby.model.dto.BabyDTO;
import com.projectbaby.Project.baby.model.dto.activity.BathDTO;
import com.projectbaby.Project.baby.model.entity.activity.Bath;
import org.mapstruct.Mapper;

@Mapper
public class BathMappingService implements ActivityMappingStrategy {

    @Override
    BathDTO mapToDTO (Bath bath);

    @Override
    Bath mapToEntity (BathDTO bathDTO);

}
