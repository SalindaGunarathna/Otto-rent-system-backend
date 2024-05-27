package com.cttorentsystem.ottorentbackend.service.impl;

import com.cttorentsystem.ottorentbackend.dtos.UserDto;
import com.cttorentsystem.ottorentbackend.entity.User;
import com.cttorentsystem.ottorentbackend.exception.ResourceNotFoundException;
import com.cttorentsystem.ottorentbackend.mapper.UserMapper;
import com.cttorentsystem.ottorentbackend.repositorys.UserReporsitory;
import com.cttorentsystem.ottorentbackend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private UserReporsitory userReporsitory;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);
        User saveUser = userReporsitory.save(user);
        return UserMapper.mapToUserDto(saveUser);
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = userReporsitory.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Admin not found with id : " + userId));
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> userList = userReporsitory.findAll();
        return userList.stream().map(UserMapper::mapToUserDto).toList();
    }

    @Override
    public UserDto updateUser(Long userId, UserDto updateAdmin) {
        User user = userReporsitory.findById(userId).orElseThrow(() ->
                new ResourceNotFoundException("Admin not found with id : " + userId));

        user.setEmail(updateAdmin.getEmail());
        user.setFirstName(updateAdmin.getFirstName());
        user.setLastName(updateAdmin.getLastName());
        user.setPhoneNO(updateAdmin.getPhoneNO());
        user.setPassword(updateAdmin.getPassword());
        user.setAddress(updateAdmin.getAddress());
        user.setProfilePic(updateAdmin.getProfilePic());
        User upDateUser = userReporsitory.save(user);

        return UserMapper.mapToUserDto(upDateUser);
    }

    @Override
    public UserDto deleteUser(Long userId) {
        User user = userReporsitory.findById(userId).orElseThrow(() ->
                new ResourceNotFoundException("Admin Not found with user Id " + userId));
        userReporsitory.deleteById(userId);
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userReporsitory.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + username));

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                user.getAuthorities() // Ensure this method returns authorities correctly
        );
    }
}
