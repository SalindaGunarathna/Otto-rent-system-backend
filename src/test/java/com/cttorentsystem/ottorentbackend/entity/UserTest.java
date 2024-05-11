package com.cttorentsystem.ottorentbackend.entity;



import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



class UserTest {

    @Test
    void testUserEntity() {
        // Given
        Long userId = 1L;
        String firstName = "John";
        String lastName = "Doe";
        String email = "john@example.com";
        String password = "password123";
        String profilePic = "profile.jpg";
        String phoneNO = "1234567890";
        String address = "123 Main St";
        User.Role role = User.Role.Customer;

        // When
        User user = new User(userId, firstName, lastName, email, password, profilePic, phoneNO, address, role);

        // Then
        assertNotNull(user);
        assertEquals(userId, user.getUserId());
        assertEquals(firstName, user.getFirstName());
        assertEquals(lastName, user.getLastName());
        assertEquals(email, user.getEmail());
        assertEquals(password, user.getPassword());
        assertEquals(profilePic, user.getProfilePic());
        assertEquals(phoneNO, user.getPhoneNO());
        assertEquals(address, user.getAddress());
        assertEquals(role, user.getRole());
    }
}
