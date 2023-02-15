package com.projectbaby.Project.baby.service;

import com.projectbaby.Project.baby.model.User;
import com.projectbaby.Project.baby.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> getUsers(){
        List<User> users = userRepository.findAll();
        return users;
    }

    public User save (User user) {
        return userRepository.save(user);
    }

}
