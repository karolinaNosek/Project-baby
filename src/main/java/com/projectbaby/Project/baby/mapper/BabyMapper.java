package com.projectbaby.Project.baby.mapper;

import com.projectbaby.Project.baby.model.dto.BabyDTO;
import com.projectbaby.Project.baby.model.entity.Baby;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface BabyMapper {
    BabyDTO mapToBabyDTO (Baby baby);
    Baby mapToBaby (BabyDTO babyDTO);


}
