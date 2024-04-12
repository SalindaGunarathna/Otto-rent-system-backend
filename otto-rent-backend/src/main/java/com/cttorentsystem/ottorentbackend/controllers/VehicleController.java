package com.cttorentsystem.ottorentbackend.controllers;

import com.cttorentsystem.ottorentbackend.dtos.VehicleDto;
import com.cttorentsystem.ottorentbackend.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@AllArgsConstructor
@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private VehicleService  vehicleService; //VehicleService

    @RequestMapping
   public ResponseEntity<VehicleDto> createVehicle(@RequestBody VehicleDto vehicleDto) {

        VehicleDto saveVehicle = vehicleService.createVehicle(vehicleDto);

        return new  ResponseEntity<> (saveVehicle, HttpStatus.CREATED);
    }


}
