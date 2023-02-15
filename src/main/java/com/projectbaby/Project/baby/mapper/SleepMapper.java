package com.projectbaby.Project.baby.mapper;

import com.projectbaby.Project.baby.activity.Sleep;
import com.projectbaby.Project.baby.dto.SleepDTO;
import org.mapstruct.Mapper;

@Mapper
public interface SleepMapper {
    SleepDTO mapToSleepDto (Sleep sleep);
    Sleep mapToSleep (SleepDTO sleepDTO);
}
