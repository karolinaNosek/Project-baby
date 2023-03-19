package com.projectbaby.Project.baby.strategies;

import com.projectbaby.Project.baby.model.dto.activity.BathDTO;
import com.projectbaby.Project.baby.model.dto.activity.DiaperDTO;
import com.projectbaby.Project.baby.model.entity.activity.Bath;
import com.projectbaby.Project.baby.model.entity.activity.Diaper;
import org.mapstruct.Mapper;

@Mapper
public class DiaperMappingService implements ActivityMappingStrategy {

    @Override
    DiaperDTO mapToDTO (Diaper diaper);

    @Override
    Diaper mapToEntity (DiaperDTO diaperDTO);

}
