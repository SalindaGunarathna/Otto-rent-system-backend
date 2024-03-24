package com.cttorentsystem.ottorentbackend.service.impl;

import com.cttorentsystem.ottorentbackend.dtos.AdminDto;
import com.cttorentsystem.ottorentbackend.entity.Admin;
import com.cttorentsystem.ottorentbackend.exception.ResourceNotFoundException;
import com.cttorentsystem.ottorentbackend.mapper.AdminMapper;
import com.cttorentsystem.ottorentbackend.repositorys.AdminReporsitory;
import com.cttorentsystem.ottorentbackend.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {


    private AdminReporsitory adminReporsitory;

    @Override
    public AdminDto createAdmin(AdminDto adminDto) {

        Admin admin = AdminMapper.mapToAdmin(adminDto);

       Admin saveAdmin = adminReporsitory.save(admin);



        return AdminMapper.mapToAdminDto(saveAdmin);
    }

    @Override
    public AdminDto getAdminById(Long adminId) {

      Admin admin =  adminReporsitory.findById(adminId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Admin not found with id : " + adminId));
        return  AdminMapper.mapToAdminDto(admin);
    }
}
