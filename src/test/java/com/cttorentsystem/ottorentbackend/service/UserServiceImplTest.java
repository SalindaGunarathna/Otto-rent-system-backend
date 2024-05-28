package com.cttorentsystem.ottorentbackend.service;

import com.cttorentsystem.ottorentbackend.dtos.UserDto;
import com.cttorentsystem.ottorentbackend.entity.User;
import com.cttorentsystem.ottorentbackend.exception.ResourceNotFoundException;
import com.cttorentsystem.ottorentbackend.mapper.UserMapper;
import com.cttorentsystem.ottorentbackend.repositorys.UserReporsitory;
import com.cttorentsystem.ottorentbackend.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceImplTest {

    @Mock
    private UserReporsitory userReporsitory;

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateUser() {
        // Given
        UserDto userDto = new UserDto();
        User user = new User();
        when(userReporsitory.save(any(User.class))).thenReturn(user);

        // When
        UserDto savedUserDto = userServiceImpl.createAdminUser(userDto);

        // Then
        assertNotNull(savedUserDto);
        verify(userReporsitory, times(1)).save(any(User.class));
    }

    @Test
    public void testGetUserById() {
        // Given
        Long userId = 1L;
        User user = new User();
        user.setUserId(userId);
        when(userReporsitory.findById(userId)).thenReturn(Optional.of(user));

        // When
        UserDto retrievedUserDto = userServiceImpl.getUserById(userId);

        // Then
        assertNotNull(retrievedUserDto);
        assertEquals(userId, retrievedUserDto.getUserId());
        verify(userReporsitory, times(1)).findById(userId);
    }

    @Test
    public void testGetUserById_ResourceNotFoundException() {
        // Given
        Long userId = 1L;
        when(userReporsitory.findById(userId)).thenReturn(Optional.empty());

        // When - Then
        assertThrows(ResourceNotFoundException.class, () -> userServiceImpl.getUserById(userId));
        verify(userReporsitory, times(1)).findById(userId);
    }

    @Test
    public void testGetAllUsers() {
        // Given
        List<User> userList = new ArrayList<>();
        when(userReporsitory.findAll()).thenReturn(userList);

        // When
        List<UserDto> allUsersDto = userServiceImpl.getAllUsers();

        // Then
        assertNotNull(allUsersDto);
        assertEquals(0, allUsersDto.size());
        verify(userReporsitory, times(1)).findAll();
    }

    @Test
    public void testUpdateUser() {
        // Given
        Long userId = 1L;
        UserDto updateUserDto = new UserDto();
        updateUserDto.setUserId(userId);
        User user = new User();
        user.setUserId(userId);
        when(userReporsitory.findById(userId)).thenReturn(Optional.of(user));
        when(userReporsitory.save(any(User.class))).thenReturn(user);

        // When
        UserDto updatedUserDto = userServiceImpl.updateUser(userId, updateUserDto);

        // Then
        assertNotNull(updatedUserDto);
        assertEquals(userId, updatedUserDto.getUserId());
        verify(userReporsitory, times(1)).findById(userId);
        verify(userReporsitory, times(1)).save(any(User.class));
    }

    @Test
    public void testDeleteUser() {
        // Given
        Long userId = 1L;
        User user = new User();
        when(userReporsitory.findById(userId)).thenReturn(Optional.of(user));

        // When
        UserDto deletedUserDto = userServiceImpl.deleteUser(userId);

        // Then
        assertNull(deletedUserDto);
        verify(userReporsitory, times(1)).findById(userId);
        verify(userReporsitory, times(1)).deleteById(userId);
    }

    @Test
    public void testDeleteUser_ResourceNotFoundException() {
        // Given
        Long userId = 1L;
        when(userReporsitory.findById(userId)).thenReturn(Optional.empty());

        // When - Then
        assertThrows(ResourceNotFoundException.class, () -> userServiceImpl.deleteUser(userId));
        verify(userReporsitory, times(1)).findById(userId);
        verify(userReporsitory, never()).deleteById(userId);
    }
}
