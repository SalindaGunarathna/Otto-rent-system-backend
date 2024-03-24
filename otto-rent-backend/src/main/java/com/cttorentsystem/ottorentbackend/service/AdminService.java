package com.cttorentsystem.ottorentbackend.service;

import com.cttorentsystem.ottorentbackend.dtos.AdminDto;

public interface AdminService {

    AdminDto  createAdmin(AdminDto adminDto);

    AdminDto getAdminById(Long adminId);

}
