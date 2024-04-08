package com.cttorentsystem.ottorentbackend.service.impl;

import com.cttorentsystem.ottorentbackend.dtos.VehicleDto;
import com.cttorentsystem.ottorentbackend.entity.Vehicle;
import com.cttorentsystem.ottorentbackend.mapper.VehicleMapper;
import com.cttorentsystem.ottorentbackend.repositorys.VehicleReporsitory;
import com.cttorentsystem.ottorentbackend.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VehicleServiceImpl implements VehicleService {

      private VehicleReporsitory vehicleReporsitory;

    @Override
    public VehicleDto createVehicle(VehicleDto vehicleDto) {

        Vehicle vehicle = VehicleMapper.mapToVehicle(vehicleDto);

       Vehicle saveVehicle = vehicleReporsitory.save(vehicle);

        return VehicleMapper.mapToVehicleDto(saveVehicle);

    }
}
