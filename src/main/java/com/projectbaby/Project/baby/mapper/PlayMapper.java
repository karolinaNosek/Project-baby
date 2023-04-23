package com.projectbaby.Project.baby.mapper;

import com.projectbaby.Project.baby.model.entity.activity.Play;
import com.projectbaby.Project.baby.model.dto.activity.PlayDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {BabyMapper.class})
public interface PlayMapper {
    @Mapping(target = "baby", ignore = true)
    PlayDTO mapToPlayDto (Play play);
    @Mapping(target = "baby", ignore = true)
    Play mapToPlay (PlayDTO playDTO);
}
