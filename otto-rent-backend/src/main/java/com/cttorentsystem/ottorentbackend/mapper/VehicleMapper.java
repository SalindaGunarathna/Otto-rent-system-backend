package com.cttorentsystem.ottorentbackend.mapper;

import com.cttorentsystem.ottorentbackend.dtos.VehicleDto;
import com.cttorentsystem.ottorentbackend.entity.Vehicle;

import java.util.stream.Collectors;

public class VehicleMapper {

    public static VehicleDto mapToVehicleDto(Vehicle vehicle) {
        VehicleDto dto = new VehicleDto();

        dto.setVehicleId(vehicle.getVehicleId());
        dto.setVehiclePrice(vehicle.getVehiclePrice());
        dto.setChassisNumber(vehicle.getChassisNumber());
        dto.setEngineNo(vehicle.getEngineNo());
        dto.setVehicleState(vehicle.getVehicleState());
        dto.setCompanyName(vehicle.getCompanyName());
        dto.setNumberOfDoors(vehicle.getNumberOfDoors());
        dto.setColor(vehicle.getColor());
        dto.setSeatingCapacity(vehicle.getSeatingCapacity());
        dto.setCondition(vehicle.getCondition());
        dto.setDimensions(mapToDimensionsDto(vehicle.getDimensions()));
        dto.setCylinderCapacity(vehicle.getCylinderCapacity());
        dto.setFuelType(vehicle.getFuelType());
        dto.setManufacturedCountry(vehicle.getManufacturedCountry());
        dto.setAssembled(vehicle.isAssembled());
        dto.setVehicleType(vehicle.getVehicleType());
        dto.setBrand(vehicle.getBrand());
        dto.setStyle(vehicle.getStyle());
        dto.setModel(vehicle.getModel());
        dto.setManufacturedYear(vehicle.getManufacturedYear());
        dto.setAlbumUrls(vehicle.getAlbum().stream().map(Photo::getPhotoURL).collect(Collectors.toList()));
        return dto;
    }

    private static VehicleDto.Dimensions mapToDimensionsDto(Vehicle.Dimensions dimensions) {
        if (dimensions == null) {
            return null;
        }
        return new VehicleDto.Dimensions(dimensions.getLength(), dimensions.getHeight(), dimensions.getWidth());
    }
}
