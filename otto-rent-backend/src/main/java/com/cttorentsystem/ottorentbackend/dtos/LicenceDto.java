package com.cttorentsystem.ottorentbackend.dtos;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LicenceDto {

    private Long licenseId;
    private Long vehicleId;
    private String licenseNumber;
    private Date expiryDate;
    private Date issueDate;
    private String issueProvince;

}
