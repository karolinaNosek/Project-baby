package com.projectbaby.Project.baby.mapper;

import com.projectbaby.Project.baby.model.entity.activity.Play;
import com.projectbaby.Project.baby.model.dto.activity.PlayDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlayMapper {
    PlayDTO mapToPlayDto (Play play);
    Play mapToPlay (PlayDTO playDTO);
}
