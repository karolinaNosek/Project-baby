package com.projectbaby.Project.baby.mapper;

import com.projectbaby.Project.baby.model.entity.activity.Bath;
import com.projectbaby.Project.baby.model.dto.activity.BathDTO;
import org.mapstruct.Mapper;

@Mapper
public interface BathMapper {
    BathDTO mapToBathDto (Bath bath);
    Bath mapToBath (BathDTO bathDTO);
}
