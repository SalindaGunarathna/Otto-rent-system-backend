package com.cttorentsystem.ottorentbackend.mapper;

import com.cttorentsystem.ottorentbackend.dtos.ServiceDetailsDto;
import com.cttorentsystem.ottorentbackend.entity.ServiceDetails;
import lombok.Getter;
import lombok.Setter;



public class ServiceDetailsMapper {

    public  static ServiceDetailsDto mapToServiceDetailsDto(ServiceDetails serviceDetails) {

        return new ServiceDetailsDto(
                serviceDetails.getServiceId(),
                serviceDetails.getServiceDate(),
                serviceDetails.getServiceType(),
                serviceDetails.getServiceCenterName(),
                serviceDetails.getServiceCenterAddress(),
                serviceDetails.getServiceCenterPhone(),
                serviceDetails.getServiceCenterEmail(),
                serviceDetails.getTravelDistance(),
                serviceDetails.getServiceCost(),
                serviceDetails.getServiceDoneBy(),
                serviceDetails.getServiceCompletionDate(),
                serviceDetails.getChangedParts(),
                VehicleMapper.mapToVehicleDto(serviceDetails.getVehicle()),
                serviceDetails.getServiceDescription()
        );
    }

    public static ServiceDetails mapToServiceDetails(ServiceDetailsDto serviceDetailsDto) {

        return new ServiceDetails(
                serviceDetailsDto.getServiceId(),
                serviceDetailsDto.getServiceDate(),
                serviceDetailsDto.getServiceType(),
                serviceDetailsDto.getServiceCenterName(),
                serviceDetailsDto.getServiceCenterAddress(),
                serviceDetailsDto.getServiceCenterPhone(),
                serviceDetailsDto.getServiceCenterEmail(),
                serviceDetailsDto.getTravelDistance(),
                serviceDetailsDto.getServiceCost(),
                serviceDetailsDto.getServiceDoneBy(),
                serviceDetailsDto.getServiceCompletionDate(),
                serviceDetailsDto.getChangedParts(),
                VehicleMapper.mapToVehicle(serviceDetailsDto.getVehicle()),
                serviceDetailsDto.getServiceDescription()
        );
    }
}
