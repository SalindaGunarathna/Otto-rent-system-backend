package com.cttorentsystem.ottorentbackend.controllers;

import com.cttorentsystem.ottorentbackend.config.CheckUserAuthorization;
import com.cttorentsystem.ottorentbackend.dtos.UserDto;
import com.cttorentsystem.ottorentbackend.service.UserService;
import com.cttorentsystem.ottorentbackend.util.JWTUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;


    private final JWTUtils jwtUtils;

    //
    //Build add user endpoint
//    @PostMapping("/admin/adduser")
//    public ResponseEntity<UserDto> createAdminUser(@RequestBody UserDto userDto) {
//        UserDto saveUser = userService.createAdminUser(userDto);
//        System.out.println(saveUser.getFirstName());
//        return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
//    }

    //Build get user by id endpoint
    // Build get user by id endpoint

    @CheckUserAuthorization
    @GetMapping("/user/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("userId") Long userId) {
        UserDto userDto = userService.getUserById(userId);
        return ResponseEntity.ok(userDto);
    }

    // Get all users method
    @GetMapping("/admin/allusers")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @CheckUserAuthorization
    @PutMapping("/user/{userId}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("userId") Long userId, @RequestBody UserDto userDto) {
        UserDto updatedUser = userService.updateUser(userId, userDto);
        return ResponseEntity.ok(updatedUser);
    }

    @CheckUserAuthorization
    @DeleteMapping("/user/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("User deleted successfully");
    }
}
