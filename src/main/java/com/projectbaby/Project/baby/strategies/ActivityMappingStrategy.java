package com.projectbaby.Project.baby.strategies;

import com.projectbaby.Project.baby.model.dto.activity.ActivityDTO;
import com.projectbaby.Project.baby.model.entity.activity.Activity;

public interface ActivityMappingStrategy {
  <T extends ActivityDTO> Activity mapToEntity (T activityDTO);
  <T extends  Activity> ActivityDTO mapToDTO (T activity);

}
