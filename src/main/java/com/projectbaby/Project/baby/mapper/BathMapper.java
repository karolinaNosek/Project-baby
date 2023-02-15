package com.projectbaby.Project.baby.mapper;

import com.projectbaby.Project.baby.activity.Bath;
import com.projectbaby.Project.baby.dto.BathDTO;
import org.mapstruct.Mapper;

@Mapper
public interface BathMapper {
    BathDTO mapToBathDto (Bath bath);
    Bath mapToBath (BathDTO bathDTO);
}
