package com.projectbaby.Project.baby.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projectbaby.Project.baby.model.dto.UserDTO;
import com.projectbaby.Project.baby.model.entity.User;
import com.projectbaby.Project.baby.repository.UserRepository;
import com.projectbaby.Project.baby.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class UserControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    void getAllUsers_returnListOfUsers() throws Exception {

        //given
        User user1 = new User();
        User user2 = new User();
        User user3 = new User();

        List<User> userList = userRepository.saveAll(Arrays.asList(user1, user2, user3));

        //when & then
        mockMvc.perform(get("/api/v1/users")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(userList)));
    }

    @Test
    void create_returnCreatedUser() throws Exception {

        //given
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1);
        userDTO.setUsername("Tata9876");
        userDTO.setPassword("qwerty");

        userService.saveUser(userDTO);

        //when & then
        mockMvc.perform(post("/api/v1/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userDTO)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(userDTO)));

    }

    @Test
    void getUserById_returnUser() throws Exception {

        //given
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("Asia2");
        userDTO.setId(1);

//        userService.saveUser(userDTO);
//        when(userService.getUserById(1)).thenReturn(userDTO);

        //when & then
        mockMvc.perform(get("/api/v1/users/{id}", userDTO.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(userDTO.getId())));
    }

    @Test
    void update_returnUpdatedUser() throws Exception {

        //given
        Integer userId = 1;
        UserDTO updatedUserDTO = new UserDTO();
        updatedUserDTO.setUsername("Jakub_Kuba");

        when(userService.updateUser(userId, updatedUserDTO)).thenReturn(updatedUserDTO);

        //when & then
        mockMvc.perform(put("/api/v1/users/{id}", userId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedUserDTO)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(updatedUserDTO)));
    }

    @Test
    void delete_shouldReturnOk() {

        //given


        //when

        //then

    }
}