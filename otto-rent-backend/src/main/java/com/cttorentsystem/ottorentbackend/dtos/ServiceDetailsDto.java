package com.cttorentsystem.ottorentbackend.dtos;

import com.cttorentsystem.ottorentbackend.entity.ChangedPart;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDetailsDto {

    private Long serviceId;
    private Date serviceDate;
    private String serviceType;
    private String serviceCenterName;
    private String serviceCenterAddress;
    private String serviceCenterPhone;
    private String serviceCenterEmail;
    private String travelDistance;
    private String serviceCost;
    private String serviceDoneBy;
    private Date serviceCompletionDate;
    private List<ChangedPart> changedParts;
    private VehicleDto vehicle;
    private String serviceDescription;
}
