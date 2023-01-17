package com.projectbaby.Project.baby.user_registration;

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
