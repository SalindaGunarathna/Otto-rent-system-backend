package com.cttorentsystem.ottorentbackend.controller;

import com.cttorentsystem.ottorentbackend.controllers.EmailController;
import com.cttorentsystem.ottorentbackend.dtos.OrderDto;
import com.cttorentsystem.ottorentbackend.entity.Vehicle;
import com.cttorentsystem.ottorentbackend.service.EmailBodyGenerator;
import com.cttorentsystem.ottorentbackend.service.impl.emailBody.AdminEmailBody;
import com.cttorentsystem.ottorentbackend.service.impl.emailBody.vehicleServiceWarningEmailBody;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class EmailControllerTest {

    @Mock
    private EmailBodyGenerator emailBodyGenerator;

    @InjectMocks
    private EmailController emailController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGenerateEmailBody() {
        // Mock the behavior of emailBodyGenerator
        OrderDto orderDto = new OrderDto();
        String expectedEmailBody = "Mock email body";
        when(emailBodyGenerator.generateEmailBody(orderDto)).thenReturn(expectedEmailBody);

        // Call the controller method
        String actualEmailBody = emailController.generateEmailBody(orderDto);

        // Verify the result
        assertEquals(expectedEmailBody, actualEmailBody);
    }

    @Test
    public void testGenerateEmailBodyforVehicleUpdate() {
        // Mock the behavior of emailBodyGenerator
        Vehicle vehicle = new Vehicle();
        String vehicleStatus = "Mock vehicle status";
        String expectedEmailBody = "Mock email body for vehicle update";
        when(emailBodyGenerator.generateEmailBodyforVehicleUpdate(vehicle, vehicleStatus)).thenReturn(expectedEmailBody);

        // Call the controller method
        String actualEmailBody = emailController.generateEmailBodyforVehicleUpdate(vehicle, vehicleStatus);

        // Verify the result
        assertEquals(expectedEmailBody, actualEmailBody);
    }
}
