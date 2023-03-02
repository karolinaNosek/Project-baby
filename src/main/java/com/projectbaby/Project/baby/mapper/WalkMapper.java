package com.projectbaby.Project.baby.mapper;

import com.projectbaby.Project.baby.model.entity.activity.Walk;
import com.projectbaby.Project.baby.model.dto.activity.WalkDTO;
import org.mapstruct.Mapper;

@Mapper
public interface WalkMapper {
    WalkDTO mapToWalkDto (Walk walk);
    Walk mapToWalk (WalkDTO walkDTO);
}
