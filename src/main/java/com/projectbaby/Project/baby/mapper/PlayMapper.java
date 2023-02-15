package com.projectbaby.Project.baby.mapper;

import com.projectbaby.Project.baby.activity.Play;
import com.projectbaby.Project.baby.dto.PlayDTO;
import org.mapstruct.Mapper;

@Mapper
public interface PlayMapper {
    PlayDTO mapToPlayDto (Play play);
    Play mapToPlay (PlayDTO playDTO);
}
