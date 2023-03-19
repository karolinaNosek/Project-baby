package com.projectbaby.Project.baby.strategies;

import com.projectbaby.Project.baby.model.dto.activity.BathDTO;
import com.projectbaby.Project.baby.model.dto.activity.PlayDTO;
import com.projectbaby.Project.baby.model.entity.activity.Bath;
import com.projectbaby.Project.baby.model.entity.activity.Play;
import org.mapstruct.Mapper;

@Mapper
public class PlayMappingService implements ActivityMappingStrategy {

    @Override
    PlayDTO mapToDTO (Play play);

    @Override
    Play mapToEntity (PlayDTO playDTO);

}
