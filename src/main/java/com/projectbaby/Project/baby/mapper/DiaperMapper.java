package com.projectbaby.Project.baby.mapper;

import com.projectbaby.Project.baby.model.entity.activity.Diaper;
import com.projectbaby.Project.baby.model.dto.activity.DiaperDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {BabyMapper.class})
public interface DiaperMapper {
    @Mapping(target = "baby", ignore = true)
    DiaperDTO mapToDiaperDto (Diaper diaper);
    @Mapping(target = "baby", ignore = true)
    Diaper mapToDiaper (DiaperDTO diaperDTO);
}
