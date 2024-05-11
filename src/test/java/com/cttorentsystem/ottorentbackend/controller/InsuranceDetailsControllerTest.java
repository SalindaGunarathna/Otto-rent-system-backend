package com.cttorentsystem.ottorentbackend.controller;

import com.cttorentsystem.ottorentbackend.controllers.InsuranceDetailsController;
import com.cttorentsystem.ottorentbackend.dtos.InsuranceDetailsDto;
import com.cttorentsystem.ottorentbackend.service.InsuranceDetailsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class InsuranceDetailsControllerTest {

    @Mock
    private InsuranceDetailsService insuranceDetailsService;

    @InjectMocks
    private InsuranceDetailsController insuranceDetailsController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddInsuranceDetails() {
        // Mock the behavior of insuranceDetailsService
        InsuranceDetailsDto mockInsuranceDetailsDto = new InsuranceDetailsDto();
        mockInsuranceDetailsDto.setInsuranceDetailsId(1L);
        when(insuranceDetailsService.addInsuranceDetails(any(InsuranceDetailsDto.class))).thenReturn(mockInsuranceDetailsDto);

        // Call the controller method
        InsuranceDetailsDto insuranceDetailsInput = new InsuranceDetailsDto();
        ResponseEntity<InsuranceDetailsDto> response = insuranceDetailsController.addInsuranceDetails(insuranceDetailsInput);

        // Verify the response
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(1L, response.getBody().getInsuranceDetailsId());
    }
}
