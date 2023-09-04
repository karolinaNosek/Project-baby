package com.projectbaby.Project.baby.controller;

import com.projectbaby.Project.baby.model.dto.BabyDTO;
import com.projectbaby.Project.baby.model.dto.UserDTO;
import com.projectbaby.Project.baby.model.entity.User;
import com.projectbaby.Project.baby.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/v1/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser (@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.saveUser(userDTO));
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById (@PathVariable(value = "id") Integer id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PutMapping ("/{id}")
    public ResponseEntity<UserDTO> updateUser (@PathVariable(value = "id") Integer id, @RequestBody UserDTO updatedUserDTO) {
        return ResponseEntity.ok(userService.updateUser(id, updatedUserDTO));
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deleteUser (@PathVariable(value = "id") Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

}
