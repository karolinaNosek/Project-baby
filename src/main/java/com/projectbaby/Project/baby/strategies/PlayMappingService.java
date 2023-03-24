package com.projectbaby.Project.baby.strategies;

import com.projectbaby.Project.baby.mapper.PlayMapper;
import com.projectbaby.Project.baby.model.dto.activity.ActivityDTO;
import com.projectbaby.Project.baby.model.dto.activity.BathDTO;
import com.projectbaby.Project.baby.model.dto.activity.PlayDTO;
import com.projectbaby.Project.baby.model.entity.activity.Activity;
import com.projectbaby.Project.baby.model.entity.activity.Bath;
import com.projectbaby.Project.baby.model.entity.activity.Play;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
public class PlayMappingService implements ActivityMappingStrategy {

    private PlayMapper playMapper;
    public PlayMappingService(PlayMapper playMapper) {
        this.playMapper = playMapper;
    }

    @Override
    public <T extends ActivityDTO> Activity mapToEntity(T activityDTO) {
        return playMapper.mapToPlay((PlayDTO) activityDTO);
    }

    @Override
    public <T extends Activity> ActivityDTO mapToDTO(T activity) {
        return playMapper.mapToPlayDto((Play) activity);
    }
}
