package com.cttorentsystem.ottorentbackend.util;





import com.cttorentsystem.ottorentbackend.dtos.UserDto;
import com.cttorentsystem.ottorentbackend.service.AuthorizationService;
import com.cttorentsystem.ottorentbackend.service.UserService;
import lombok.AllArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;

@Aspect
@Component
@AllArgsConstructor
public class AuthorizationAspect {

    private final AuthorizationService authorizationService;
    private final UserService userService;
    private final HttpServletRequest request;

    @Before("@annotation(com.cttorentsystem.ottorentbackend.config.CheckUserAuthorization) && args(userId,..)")
    public void checkAuthorization(Long userId) {
        UserDto userDto = userService.getUserById(userId);

        if (userDto == null) {
            throw new RuntimeException("User not found");
        }

        authorizationService.authorizeUser(request, userDto.getEmail());
    }
}