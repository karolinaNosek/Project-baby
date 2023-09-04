package com.projectbaby.Project.baby.testutils;

import com.projectbaby.Project.baby.exception.ResourceNotFoundException;
import com.projectbaby.Project.baby.model.dto.UserDTO;
import com.projectbaby.Project.baby.model.entity.User;
import com.projectbaby.Project.baby.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TestUserCreator {

    public static UserDTO createUserDTOWithId (Integer id) {
        UserDTO userDTOWithId = new UserDTO();
        userDTOWithId.setId(1);
        return userDTOWithId;
    }

    public static User createUserWithId (Integer id) {
        User userWithId = new User();
        userWithId.setId(1);
        return userWithId;
    }

    public static UserDTO createUserDTOWithUsername (String username) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(username);
        return userDTO;
    }

    public static User createUserWithUsername (String username) {
        User user = new User();
        user.setUsername(username);
        return user;
    }

    public static UserDTO updateUserDTOByPassword (Integer id, String password) {
        UserDTO updatedUserDTOByPassword = new UserDTO();
        updatedUserDTOByPassword.setPassword(password);
        return updatedUserDTOByPassword;
    }

    public static User updateUserByPassword (Integer id, String password) {
        User updatedUserByPassword = new User();
        updatedUserByPassword.setPassword(password);
        return updatedUserByPassword;
    }

    public static void exception () throws ResourceNotFoundException {
        throw new ResourceNotFoundException("User not found!");
    }

    public static User deleteUserById (Integer id){
        User userById = new User();
        userById.setId(id);
        return userById;


    }



}
