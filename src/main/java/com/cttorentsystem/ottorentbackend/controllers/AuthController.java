package com.cttorentsystem.ottorentbackend.controllers;


import com.cttorentsystem.ottorentbackend.dtos.ReqRes;
import com.cttorentsystem.ottorentbackend.dtos.UserDto;
import com.cttorentsystem.ottorentbackend.entity.User;
import com.cttorentsystem.ottorentbackend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")

public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<ReqRes> signUp(@RequestBody User signUpRequest){
        return ResponseEntity.ok(authService.signUp(signUpRequest));
    }

    @PostMapping("/admin/signup/{Secret_key}" )
    public ResponseEntity<ReqRes> adminSignUp(@RequestBody User signUpRequest,@PathVariable String Secret_key){
        if(!Secret_key.equals("admin123")){
            ReqRes resp = new ReqRes();
            resp.setStatusCode(500);
            resp.setError("Invalid Secret Key");
            return ResponseEntity.ok(resp);
        }else{
            return ResponseEntity.ok(authService.signUpAdmin(signUpRequest));
        }

    }

    @PostMapping("/signin")
    public ResponseEntity<ReqRes> signIn(@RequestBody ReqRes signInRequest){
        return ResponseEntity.ok(authService.signIn(signInRequest));
    }
    @PostMapping("/refresh")
    public ResponseEntity<ReqRes> refreshToken(@RequestBody ReqRes refreshTokenRequest){
        return ResponseEntity.ok(authService.refreshToken(refreshTokenRequest));
    }
}
