package com.projectbaby.Project.baby.mapper;

import com.projectbaby.Project.baby.activity.Activity;
import com.projectbaby.Project.baby.dto.ActivityDTO;
import org.mapstruct.Mapper;

@Mapper
public interface ActivityMapper {
    ActivityDTO mapToActivityDto (Activity activity);
    Activity mapToActivity (ActivityDTO activityDTO);

}
