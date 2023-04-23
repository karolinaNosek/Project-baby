package com.projectbaby.Project.baby.service;

import com.projectbaby.Project.baby.exception.ResourceNotFoundException;
import com.projectbaby.Project.baby.mapper.UserMapper;
import com.projectbaby.Project.baby.model.dto.BabyDTO;
import com.projectbaby.Project.baby.model.dto.UserDTO;
import com.projectbaby.Project.baby.model.entity.Baby;
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
                .map(userMapper::mapToUserDTO)
                .collect(Collectors.toList());
        return usersDTO;
    }
    public UserDTO getUserById(Integer id) {
        User userById = userRepository
                .findById((long) id)
                .orElseThrow(() -> new ResourceNotFoundException("Activity not found for this id: " + id ));
        UserDTO userDTO = userMapper.mapToUserDTO(userById);
        return userDTO;
    }

    public UserDTO save (UserDTO userDTO) {
        User user = userMapper.mapToUser(userDTO);
        userRepository.save(user);
        UserDTO userDTO1 = userMapper.mapToUserDTO(user);
                return userDTO1;
    }

    public UserDTO update(int id, UserDTO updatedUserDTO) {
        User userById = userMapper.mapToUser(updatedUserDTO);
        userRepository
                .findById((long) id)
                .orElseThrow(() -> new ResourceNotFoundException("Baby not found for this id: " + id ));
        userById.setUsername(updatedUserDTO.getUsername());
        userById.setEmail(updatedUserDTO.getEmail());
        userById.setPassword(updatedUserDTO.getPassword());
        userRepository.save(userById);
        UserDTO userDTO2 = userMapper.mapToUserDTO(userById);
        return userDTO2;
    }

    public void delete(int id) {
        if (userRepository.existsById((long) id)) {
            userRepository.deleteById((long) id);
        } else {
            throw new IllegalArgumentException();
        }
    }

}
