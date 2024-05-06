package com.cttorentsystem.ottorentbackend.mapper;


import com.cttorentsystem.ottorentbackend.dtos.UserDto;

import com.cttorentsystem.ottorentbackend.entity.User;

public class UserMapper {

    public static UserDto mapToUserDto(User admin) {


        return new UserDto(
                admin.getUserId(),
                admin.getFirstName(),
                admin.getLastName(),
                admin.getEmail(),
                admin.getPassword(),
                admin.getProfilePic(),
                admin.getPhoneNO(),
                admin.getAddress(),
                admin.getRole(),
                admin.getOrders()


        );
    }

    public  static User mapToUser(UserDto adminDto) {

        return new User(
                adminDto.getUserId(),
                adminDto.getFirstName(),
                adminDto.getLastName(),
                adminDto.getEmail(),
                adminDto.getPassword(),
                adminDto.getProfilePic(),
                adminDto.getPhoneNO(),
                adminDto.getAddress(),
                adminDto.getRole(),
                adminDto.getOrders()
        );
    }
}
