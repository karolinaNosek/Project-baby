package com.projectbaby.Project.baby.strategies;

import com.projectbaby.Project.baby.model.dto.activity.ActivityDTO;
import com.projectbaby.Project.baby.model.entity.activity.Activity;

public interface ActivityMappingStrategy {
  public mapToEntity (ActivityDTO activityDTO);
  public mapToDTO (Activity activity);

}
