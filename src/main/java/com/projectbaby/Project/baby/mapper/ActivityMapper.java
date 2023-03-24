package com.projectbaby.Project.baby.mapper;

import com.projectbaby.Project.baby.model.entity.activity.Activity;
import com.projectbaby.Project.baby.model.dto.activity.ActivityDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ActivityMapper {
    ActivityDTO mapToActivityDto (Activity activity);

    Activity mapToActivity (ActivityDTO activityDTO);

}
