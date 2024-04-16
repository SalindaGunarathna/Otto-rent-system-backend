package com.cttorentsystem.ottorentbackend.dtos;

import com.cttorentsystem.ottorentbackend.entity.Vehicle;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDetailsDto {

    private Long serviceDetailsId;
    private  String serviceDate;
    private String serviceCenterName;
    private String serviceCenterLocation;
    private  String travelDistance;
    private  String serviceCost;
    private Vehicle vehicleId;




}
