package com.cttorentsystem.ottorentbackend.controllers;


import com.cttorentsystem.ottorentbackend.dtos.AdminDto;
import com.cttorentsystem.ottorentbackend.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/admins")
public class AdminController {

    private AdminService adminService;

    //Build add admin endpoint

    @PostMapping
    public ResponseEntity<AdminDto> createAdmin( @RequestBody AdminDto adminDto) {

        AdminDto saveAdmin = adminService.createAdmin(adminDto);
        System.out.println("hello");

        return  new ResponseEntity<>(saveAdmin, HttpStatus.CREATED);
    }

    //Build get admin by id endpoint
    @GetMapping("/{adminId}")
    public ResponseEntity<AdminDto> getAdminById( @PathVariable("adminId") Long adminId) {

        AdminDto adminDto = adminService.getAdminById(adminId);
        return ResponseEntity.ok(adminDto);
    }



}
