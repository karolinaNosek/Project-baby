package com.projectbaby.Project.baby.mapper;

import com.projectbaby.Project.baby.dto.UserDTO;
import com.projectbaby.Project.baby.model.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserDTO mapToUserDto (User user);
    User mapToUser (UserDTO userDTO);
}
