package com.cttorentsystem.ottorentbackend.service;

import com.cttorentsystem.ottorentbackend.dtos.VehicleDto;

public interface VehicleService {

    VehicleDto createVehicle(VehicleDto vehicleDto);

    VehicleDto getVehicleById(Long vehicleId);
}
