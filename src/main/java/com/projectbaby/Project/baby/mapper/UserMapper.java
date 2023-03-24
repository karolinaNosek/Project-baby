package com.projectbaby.Project.baby.mapper;

import com.projectbaby.Project.baby.model.dto.UserDTO;
import com.projectbaby.Project.baby.model.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO mapToUserDTO (User user);
    User mapToUser (UserDTO userDTO);
}
