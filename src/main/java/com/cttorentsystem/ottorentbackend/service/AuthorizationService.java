package com.cttorentsystem.ottorentbackend.service;


import com.cttorentsystem.ottorentbackend.exception.UnauthorizedException;
import com.cttorentsystem.ottorentbackend.util.JWTUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;

@Service
@AllArgsConstructor
public class AuthorizationService {

    private final JWTUtils jwtUtils;


    public void authorizeUser(HttpServletRequest request, String userEmail) {
        String token = request.getHeader("Authorization").substring(7); // Remove "Bearer " prefix
        String username = jwtUtils.extractUsername(token);

        if (!username.equals(userEmail)) {
            throw new UnauthorizedException("Unauthorized: You are not allowed to access this user's information");
        }
    }
}
