package com.cttorentsystem.ottorentbackend.controllers;


import com.cttorentsystem.ottorentbackend.dtos.OrderDto;
import com.cttorentsystem.ottorentbackend.entity.Order;
import com.cttorentsystem.ottorentbackend.entity.User;
import com.cttorentsystem.ottorentbackend.entity.Vehicle;
import com.cttorentsystem.ottorentbackend.service.EmailBodyGenerator;
import com.cttorentsystem.ottorentbackend.service.EmailService;
import com.cttorentsystem.ottorentbackend.service.impl.AdminEmailBody;
import com.cttorentsystem.ottorentbackend.service.impl.CustomerEmailBody;
import com.cttorentsystem.ottorentbackend.service.impl.EmailServiceImpl;

import com.cttorentsystem.ottorentbackend.service.impl.vehicleServiceWarningEmailBody;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;



@AllArgsConstructor
public class EmailController {



    private EmailBodyGenerator emailBodyGenerator;



    public EmailController(String receiver) {

        if(receiver.equals("Admin-orderUpdate")){
            emailBodyGenerator = new AdminEmailBody();
        }else if (receiver.equals("Admin-vehicleUpdate")){
            emailBodyGenerator = new vehicleServiceWarningEmailBody();
        } else if(receiver.equals("Customer")){
            emailBodyGenerator = new CustomerEmailBody();
        }
    };


    public String generateEmailBody(OrderDto order) {

        String emailBody = emailBodyGenerator.generateEmailBody(order);
        return emailBody;
    }

    public String generateEmailBodyforVehicleUpdate(Vehicle vehicle) {

        String emailBody = emailBodyGenerator.generateEmailBodyforVehicleUpdate(vehicle);
        return emailBody;
    }





}
