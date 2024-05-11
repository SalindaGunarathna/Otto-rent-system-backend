package com.cttorentsystem.ottorentbackend.controller;

import com.cttorentsystem.ottorentbackend.controllers.LicenceController;
import com.cttorentsystem.ottorentbackend.dtos.LicenceDto;
import com.cttorentsystem.ottorentbackend.service.LicenceService;
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

public class LicenceControllerTest {

    @Mock
    private LicenceService licenceService;

    @InjectMocks
    private LicenceController licenceController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateLicence() {
        // Mock the behavior of licenceService
        LicenceDto mockLicenceDto = new LicenceDto();
        mockLicenceDto.setLicenceId(1L);
        when(licenceService.createLicence(any(LicenceDto.class))).thenReturn(mockLicenceDto);

        // Call the controller method
        LicenceDto licenceInput = new LicenceDto();
        ResponseEntity<LicenceDto> response = licenceController.createLicence(licenceInput);

        // Verify the response
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(1L, response.getBody().getLicenceId());
    }
}
