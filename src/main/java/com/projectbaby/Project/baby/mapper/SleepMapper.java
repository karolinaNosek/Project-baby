package com.projectbaby.Project.baby.mapper;

import com.projectbaby.Project.baby.model.entity.activity.Sleep;
import com.projectbaby.Project.baby.model.dto.activity.SleepDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {BabyMapper.class})
public interface SleepMapper {
    @Mapping(target = "baby", ignore = true)
    SleepDTO mapToSleepDto (Sleep sleep);
    @Mapping(target = "baby", ignore = true)
    Sleep mapToSleep (SleepDTO sleepDTO);
}
