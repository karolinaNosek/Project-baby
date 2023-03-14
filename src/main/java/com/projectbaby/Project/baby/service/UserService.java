package com.projectbaby.Project.baby.service;

import com.projectbaby.Project.baby.mapper.UserMapper;
import com.projectbaby.Project.baby.model.dto.UserDTO;
import com.projectbaby.Project.baby.model.entity.User;
import com.projectbaby.Project.baby.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {

        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }
    public List<UserDTO> getUsersDTO(){
        List<User> users = userRepository.findAll();
        List<UserDTO> usersDTO = users
                .stream()
                .map(this::mapToUserDTO)
                .collect(Collectors.toList());
        return usersDTO;
    }

    public UserDTO save (UserDTO userDTO) {
        User user = userMapper.mapToUser(userDTO);
        userRepository.save(user);
        UserDTO userDTO1 = mapToUserDTO (user);
                return userDTO1;

    }

}
