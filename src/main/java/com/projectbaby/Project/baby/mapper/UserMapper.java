package com.projectbaby.Project.baby.mapper;

import com.projectbaby.Project.baby.model.dto.UserDTO;
import com.projectbaby.Project.baby.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "baby", ignore = true)
    UserDTO mapToUserDTO (User user);
    @Mapping(target = "baby", ignore = true)
    User mapToUser (UserDTO userDTO);
}
