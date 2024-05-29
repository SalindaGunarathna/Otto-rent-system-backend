package com.cttorentsystem.ottorentbackend.validators;

import com.cttorentsystem.ottorentbackend.dtos.VehicleDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class VehicleValidator {

    public static ResponseEntity<String> validateVehicle(VehicleDto vehicleDto) {
        System.out.println("Validation is running for " + vehicleDto);
        if (vehicleDto.getRegistrationNo() == null) {
            return new ResponseEntity<>("Registration number is missing", HttpStatus.BAD_REQUEST);
        } else if (vehicleDto.getColor() == null) {
            return new ResponseEntity<>("Color is missing", HttpStatus.BAD_REQUEST);
        } else if (vehicleDto.getSeatingCapacity() <= 0) {
            return new ResponseEntity<>("Seating capacity must be greater than 0", HttpStatus.BAD_REQUEST);
        } else if (vehicleDto.getNumberOfDoors() <= 0) {
            System.out.println("Checking number of doors");
            return new ResponseEntity<>("Number of doors must be greater than 0", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
