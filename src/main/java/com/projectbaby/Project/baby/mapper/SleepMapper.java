package com.projectbaby.Project.baby.mapper;

import com.projectbaby.Project.baby.model.entity.activity.Sleep;
import com.projectbaby.Project.baby.model.dto.activity.SleepDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SleepMapper {
    SleepDTO mapToSleepDto (Sleep sleep);
    Sleep mapToSleep (SleepDTO sleepDTO);
}
