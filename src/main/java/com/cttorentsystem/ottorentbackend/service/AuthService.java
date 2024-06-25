package com.cttorentsystem.ottorentbackend.service;


import com.cttorentsystem.ottorentbackend.dtos.ReqRes;
import com.cttorentsystem.ottorentbackend.dtos.UserDto;
import com.cttorentsystem.ottorentbackend.entity.User;
import com.cttorentsystem.ottorentbackend.mapper.UserMapper;
import com.cttorentsystem.ottorentbackend.repositorys.UserReporsitory;
import com.cttorentsystem.ottorentbackend.util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AuthService {

    @Autowired
    private UserReporsitory ourUserRepo;
    @Autowired
    private JWTUtils jwtUtils;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    public ReqRes signUp(User registrationRequest){
        ReqRes resp = new ReqRes();
        try {
            User ourUsers = registrationRequest ;
            ourUsers.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
            ourUsers.setRole("USER");
            User newUser = ourUserRepo.save(ourUsers);

            UserDto ourUserResult = UserMapper.mapToUserDto(newUser);
            if (ourUserResult != null && ourUserResult.getUserId()>0) {
                var jwt = jwtUtils.generateToken(ourUsers);
                resp.setUser(ourUserResult);
                resp.setMessage("User Saved Successfully");
                resp.setStatusCode(200);
                resp.setToken(jwt);

            }
        }catch (Exception e){
            resp.setStatusCode(500);
            resp.setError(e.getMessage());
        }
        return resp;
    }

    public ReqRes signUpAdmin(User registrationRequest){
        ReqRes resp = new ReqRes();
        try {
            User ourUsers = registrationRequest ;
            ourUsers.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
            ourUsers.setRole("ADMIN");
            User newUser = ourUserRepo.save(ourUsers);

            UserDto ourUserResult = UserMapper.mapToUserDto(newUser);
            if (ourUserResult != null && ourUserResult.getUserId()>0) {
                var jwt = jwtUtils.generateToken(ourUsers);
                resp.setToken(jwt);
                resp.setUser(ourUserResult);
                resp.setMessage("Admin Saved Successfully");
                resp.setStatusCode(200);
            }
        }catch (Exception e){
            resp.setStatusCode(500);
            resp.setError(e.getMessage());
        }
        return resp;
    }



    public ReqRes signIn(ReqRes signinRequest){
        ReqRes response = new ReqRes();

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signinRequest.getEmail(),signinRequest.getPassword()));
            var user = ourUserRepo.findByEmail(signinRequest.getEmail()).orElseThrow();
            System.out.println("USER IS: "+ user.getEmail());
            var jwt = jwtUtils.generateToken(user);
            var refreshToken = jwtUtils.generateRefreshToken(new HashMap<>(), user);
            response.setUser(UserMapper.mapToUserDto(user));
            response.setStatusCode(200);
            response.setToken(jwt);
            response.setRefreshToken(refreshToken);
            response.setExpirationTime("24Hr");
            response.setMessage("Successfully Signed In");
        }catch (Exception e){
            response.setStatusCode(500);
            response.setError(e.getMessage());
        }
        return response;
    }

    public ReqRes refreshToken(ReqRes refreshTokenReqiest){
        ReqRes response = new ReqRes();
        String ourEmail = jwtUtils.extractUsername(refreshTokenReqiest.getToken());
        User users = ourUserRepo.findByEmail(ourEmail).orElseThrow();
        if (jwtUtils.isTokenValid(refreshTokenReqiest.getToken(), users)) {
            var jwt = jwtUtils.generateToken(users);
            response.setStatusCode(200);
            response.setToken(jwt);
            response.setRefreshToken(refreshTokenReqiest.getToken());
            response.setExpirationTime("24Hr");
            response.setMessage("Successfully Refreshed Token");
        }
        response.setStatusCode(500);
        return response;
    }
}
