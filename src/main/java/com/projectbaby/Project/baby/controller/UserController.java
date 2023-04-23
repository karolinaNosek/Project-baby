package com.projectbaby.Project.baby.controller;

import com.projectbaby.Project.baby.model.dto.BabyDTO;
import com.projectbaby.Project.baby.model.dto.UserDTO;
import com.projectbaby.Project.baby.model.entity.User;
import com.projectbaby.Project.baby.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getUsersDTO() {
        return ResponseEntity.ok(userService.getUsersDTO());
    }

    @PostMapping("/users")
    public ResponseEntity<UserDTO> createUserDTO (@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.save(userDTO));
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById (@PathVariable(value = "id") int id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PutMapping ("/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable(value = "id") int id, @RequestBody UserDTO updatedUserDTO) {
        return ResponseEntity.ok(userService.update(id, updatedUserDTO));
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> delete (@PathVariable(value = "id") int id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }

}
