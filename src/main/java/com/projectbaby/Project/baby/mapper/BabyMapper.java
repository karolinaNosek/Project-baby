package com.projectbaby.Project.baby.mapper;

import com.projectbaby.Project.baby.model.dto.BabyDTO;
import com.projectbaby.Project.baby.model.entity.Baby;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper (componentModel = "spring")
public interface BabyMapper {
    @Mapping(target = "activities", ignore = true)
    BabyDTO mapToBabyDTO (Baby baby);
    @Mapping(target = "activities", ignore = true)
    Baby mapToBaby (BabyDTO babyDTO);


}
