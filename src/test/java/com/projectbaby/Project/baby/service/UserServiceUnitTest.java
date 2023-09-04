package com.projectbaby.Project.baby.service;

import com.projectbaby.Project.baby.exception.ResourceNotFoundException;
import com.projectbaby.Project.baby.mapper.UserMapper;
import com.projectbaby.Project.baby.model.dto.UserDTO;
import com.projectbaby.Project.baby.model.entity.User;
import com.projectbaby.Project.baby.repository.UserRepository;
import com.projectbaby.Project.baby.testutils.TestBabyCreator;
import com.projectbaby.Project.baby.testutils.TestUserCreator;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@Import(UserService.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class UserServiceUnitTest {

    @MockBean
    UserRepository userRepository;

    @MockBean
    UserMapper userMapper;

    @Autowired
    UserService userService;

    @BeforeEach
    public void setup (){
       UserDTO userDTOWithId = TestUserCreator.createUserDTOWithId(1);
       User userWithId = TestUserCreator.createUserWithId(1);

        User mappedUser = userMapper.mapToUser(userDTOWithId);

       userRepository.save(userWithId);
       userRepository.save(mappedUser);
    }



    @Test
    void verifyIfUsersEquals() {

        //given
        UserDTO userDTO = TestUserCreator.createUserDTOWithUsername("Mama123");
        User mappedUser = TestUserCreator.createUserWithUsername("Mama123");
        when(userMapper.mapToUser(any())).thenReturn(mappedUser);
        when(userRepository.save(any())).thenReturn(mappedUser);
        when(userMapper.mapToUserDTO(any())).thenReturn(userDTO);

        //when
        UserDTO savedUser = userService.saveUser(userDTO);

        //then
        assertEquals(userDTO.getUsername(), savedUser.getUsername());

    }


    @Test
    void updateUser_shouldUpdateUserByPassword() {

        //given
        UserDTO userDTO1 = TestUserCreator.updateUserDTOByPassword(1, "qwerty");
        User mappedUser = TestUserCreator.updateUserByPassword(1, "qwerty");
        when(userMapper.mapToUser(any())).thenReturn(mappedUser);
        when(userRepository.save(any())).thenReturn(mappedUser);
        when(userMapper.mapToUserDTO(any())).thenReturn(userDTO1);
        when(userRepository.findById(any())).thenReturn(Optional.of(mappedUser));

        //when
        UserDTO updatedUserDTO = userService.updateUser(1, userDTO1);

        //then
        assertEquals(userDTO1.getPassword(), updatedUserDTO.getPassword());
    }

    @Test
    void verifyMessage_ResourceNotFoundException() {

        //given
        String expectedMessage = "User not found!";

        //when
        String actualMessage = null;
        try {
            TestUserCreator.exception();
        } catch (ResourceNotFoundException msg) {
            actualMessage = msg.getMessage();
        }

        //then
        assertEquals(actualMessage, expectedMessage);
    }


    @Test
    void deleteUser_verifyIfUserWasDeleted() {

        //given
        Integer id = 1;
        when(userRepository.existsById(id)).thenReturn(true);

        //when
        userService.deleteUser(id);

        //then
        verify(userRepository, times(1)).deleteById(id);

    }
}