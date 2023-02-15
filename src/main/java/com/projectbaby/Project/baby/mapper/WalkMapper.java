package com.projectbaby.Project.baby.mapper;

import com.projectbaby.Project.baby.activity.Walk;
import com.projectbaby.Project.baby.dto.WalkDTO;
import org.mapstruct.Mapper;

@Mapper
public interface WalkMapper {
    WalkDTO mapToWalkDto (Walk walk);
    Walk mapToWalk (WalkDTO walkDTO);
}
