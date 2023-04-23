package com.projectbaby.Project.baby.mapper;

import com.projectbaby.Project.baby.model.entity.activity.Bath;
import com.projectbaby.Project.baby.model.dto.activity.BathDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper (componentModel = "spring", uses = {BabyMapper.class})
public interface BathMapper {
    @Mapping(target = "baby", ignore = true)
    BathDTO mapToBathDto (Bath bath);
    @Mapping(target = "baby", ignore = true)
    Bath mapToBath (BathDTO bathDTO);
}
