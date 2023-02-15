package com.projectbaby.Project.baby.mapper;

import com.projectbaby.Project.baby.dto.BabyDTO;
import com.projectbaby.Project.baby.model.Baby;
import org.mapstruct.Mapper;

@Mapper
public interface BabyMapper {
    BabyDTO mapToBabyDto (Baby baby);
    Baby mapToBaby (BabyDTO babyDTO);
}
