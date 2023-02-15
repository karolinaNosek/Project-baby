package com.projectbaby.Project.baby.mapper;

import com.projectbaby.Project.baby.activity.Diaper;
import com.projectbaby.Project.baby.dto.DiaperDTO;
import org.mapstruct.Mapper;

@Mapper
public interface DiaperMapper {
    DiaperDTO mapToDiaperDto (Diaper diaper);
    Diaper mapToDiaper (DiaperDTO diaperDTO);
}
