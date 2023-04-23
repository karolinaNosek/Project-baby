package com.projectbaby.Project.baby.mapper;

import com.projectbaby.Project.baby.model.entity.activity.Walk;
import com.projectbaby.Project.baby.model.dto.activity.WalkDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {BabyMapper.class})
public interface WalkMapper {
    @Mapping(target = "baby", ignore = true)
    WalkDTO mapToWalkDto (Walk walk);
    @Mapping(target = "baby", ignore = true)
    Walk mapToWalk (WalkDTO walkDTO);
}
