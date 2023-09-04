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
    public List<UserDTO> getAllUsers(){
        List<User> users = userRepository.findAll();
        List<UserDTO> usersDTO = users
                .stream()
                .map(userMapper::mapToUserDTO)
                .collect(Collectors.toList());
        return usersDTO;
    }
    public UserDTO getUserById(Integer id) {
        User userById = userRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Activity not found for this id: " + id ));
        UserDTO userDTO = userMapper.mapToUserDTO(userById);
        return userDTO;
    }

    public UserDTO saveUser (UserDTO userDTO) {
        User user = userMapper.mapToUser(userDTO);
        userRepository.save(user);
        UserDTO userDTO1 = userMapper.mapToUserDTO(user);
                return userDTO1;
    }

    public UserDTO updateUser (Integer id, UserDTO updatedUserDTO) {
        User existingUser = userRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id: " + id ));
        existingUser.setUsername(updatedUserDTO.getUsername());
        existingUser.setEmail(updatedUserDTO.getEmail());
        existingUser.setPassword(updatedUserDTO.getPassword());
        userRepository.save(existingUser);
        UserDTO existingUserDTO = userMapper.mapToUserDTO(existingUser);
        return existingUserDTO;
    }

    public void deleteUser (Integer id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException();
        }
    }

}
