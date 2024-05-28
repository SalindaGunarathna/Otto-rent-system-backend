package com.cttorentsystem.ottorentbackend.service;


import com.cttorentsystem.ottorentbackend.dtos.UserDto;

import java.util.List;

public interface UserService {

    UserDto createAdminUser(UserDto adminDto);

    UserDto getUserById(Long adminId);

    List<UserDto> getAllUsers();

    UserDto updateUser(Long adminId,UserDto updateAdmin);

    UserDto deleteUser (Long adminId);

}
