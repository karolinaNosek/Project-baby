package com.projectbaby.Project.baby.mapper;

import com.projectbaby.Project.baby.model.entity.activity.Diaper;
import com.projectbaby.Project.baby.model.dto.activity.DiaperDTO;
import org.mapstruct.Mapper;

@Mapper
public interface DiaperMapper {
    DiaperDTO mapToDiaperDto (Diaper diaper);
    Diaper mapToDiaper (DiaperDTO diaperDTO);
}
