package com.cttorentsystem.ottorentbackend.controller;

import org.mockito.Mock;
import com.cttorentsystem.ottorentbackend.controllers.UserController;
import com.cttorentsystem.ottorentbackend.dtos.UserDto;
import com.cttorentsystem.ottorentbackend.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateUser() {
        // Mock the behavior of userService
        UserDto mockUserDto = new UserDto();
        mockUserDto.setFirstName("John");
        when(userService.createAdminUser(any(UserDto.class))).thenReturn(mockUserDto);

        // Call the controller method
        UserDto userInput = new UserDto();
        userInput.setFirstName("John");
        ResponseEntity<UserDto> response = userController.createAdminUser(userInput);

        // Verify the response
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("John", response.getBody().getFirstName());
    }

    @Test
    public void testGetUserById() {
        // Mock the behavior of userService
        UserDto mockUserDto = new UserDto();
        mockUserDto.setUserId(1L);
        when(userService.getUserById(1L)).thenReturn(mockUserDto);

        // Call the controller method
        ResponseEntity<UserDto> response = userController.getUserById(1L);

        // Verify the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1L, response.getBody().getUserId());
    }


    @Test
    public void testGetAllUsers() {
        // Mock the behavior of userService
        List<UserDto> mockUserList = new ArrayList<>();
        UserDto user1 = new UserDto();
        user1.setUserId(1L);
        mockUserList.add(user1);
        when(userService.getAllUsers()).thenReturn(mockUserList);

        // Call the controller method
        ResponseEntity<List<UserDto>> response = userController.getAllUsers();

        // Verify the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        assertEquals(1L, response.getBody().get(0).getUserId());
    }


    @Test
    public void testUpdateUser() {
        // Mock the behavior of userService
        UserDto userDto = new UserDto();
        userDto.setUserId(1L);
        when(userService.updateUser(1L, userDto)).thenReturn(userDto);

        // Call the controller method
        ResponseEntity<UserDto> response = userController.updateUser(1L, userDto);

        // Verify the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1L, response.getBody().getUserId());
    }

    @Test
    public void testDeleteUser() {
        // Call the controller method
        ResponseEntity<String> response = userController.deleteUser(1L);

        // Verify the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("User deleted successfully", response.getBody());
    }




}
