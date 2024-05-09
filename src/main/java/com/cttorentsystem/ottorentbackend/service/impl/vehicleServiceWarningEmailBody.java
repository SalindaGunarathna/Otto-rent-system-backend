package com.cttorentsystem.ottorentbackend.service.impl;

import com.cttorentsystem.ottorentbackend.dtos.OrderDto;
import com.cttorentsystem.ottorentbackend.dtos.VehicleDto;
import com.cttorentsystem.ottorentbackend.entity.ServiceDetails;
import com.cttorentsystem.ottorentbackend.entity.Vehicle;
import com.cttorentsystem.ottorentbackend.service.EmailBodyGenerator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class vehicleServiceWarningEmailBody implements EmailBodyGenerator {


    @Override
    public String generateEmailBody(OrderDto vehicle) {

        return null;
    }

    @Override
    public String generateEmailBodyforVehicleUpdate(Vehicle vehicle) {
        StringBuilder emailBody = new StringBuilder();

        // Add vehicle information to the email body
        emailBody.append("Vehicle Information:\n");
        emailBody.append("Vehicle ID: ").append(vehicle.getVehicleId()).append("\n");
        emailBody.append("Registration No: ").append(vehicle.getRegistrationNo()).append("\n");
        emailBody.append("Brand: ").append(vehicle.getBrand()).append("\n");
        emailBody.append("Model: ").append(vehicle.getModel()).append("\n");
        emailBody.append("Next Service Details:\n");

        // Add service details to the email body
        List<ServiceDetails> serviceDetailsList = vehicle.getServiceDetails();
        for (ServiceDetails serviceDetail : serviceDetailsList) {
            emailBody.append("Service Date: ").append(serviceDetail.getServiceDate()).append("\n");
            emailBody.append("Service Center: ").append(serviceDetail.getServiceCenterName()).append("\n");
            emailBody.append("Next Service Date: ").append(serviceDetail.getNextServiceDate()).append("\n");
            emailBody.append("Next Service Distance: ").append(serviceDetail.getNextServiceDistance()).append("\n\n");
        }

        return emailBody.toString();
    }
}
