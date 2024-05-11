package com.cttorentsystem.ottorentbackend.controller;

import com.cttorentsystem.ottorentbackend.controllers.ServiceDetailsController;
import com.cttorentsystem.ottorentbackend.dtos.ServiceDetailsDto;
import com.cttorentsystem.ottorentbackend.service.ServiceDetailsService;
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

public class ServiceDetailsControllerTest {

    @Mock
    private ServiceDetailsService serviceDetailsService;

    @InjectMocks
    private ServiceDetailsController serviceDetailsController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateServiceDetails() {
        // Mock the behavior of serviceDetailsService
        ServiceDetailsDto mockServiceDetailsDto = new ServiceDetailsDto();
        mockServiceDetailsDto.setServiceDetailsId(1L);
        when(serviceDetailsService.createServiceDetails(any(ServiceDetailsDto.class))).thenReturn(mockServiceDetailsDto);

        // Call the controller method
        ServiceDetailsDto serviceDetailsInput = new ServiceDetailsDto();
        ResponseEntity<ServiceDetailsDto> response = serviceDetailsController.createServiceDetails(serviceDetailsInput);

        // Verify the response
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(1L, response.getBody().getServiceDetailsId());
    }
}
