package com.cttorentsystem.ottorentbackend.controller;


import com.cttorentsystem.ottorentbackend.controllers.VehicleController;
import com.cttorentsystem.ottorentbackend.dtos.SuggestVehicleRequest;
import com.cttorentsystem.ottorentbackend.dtos.VehicleDto;
import com.cttorentsystem.ottorentbackend.service.VehicleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VehicleControllerTest {

    @Mock
    private VehicleService vehicleService;

    @InjectMocks
    private VehicleController vehicleController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

//    @Test
//    public void testCreateVehicle() {
//        // Mock the behavior of vehicleService
//        VehicleDto mockVehicleDto = new VehicleDto();
//        mockVehicleDto.setVehicleId(1L);
//        when(vehicleService.createVehicle(any(VehicleDto.class))).thenReturn(mockVehicleDto);
//
//        // Call the controller method
//        VehicleDto vehicleInput = new VehicleDto();
//        vehicleInput.setVehicleId(1L);
//        ResponseEntity<?> response = vehicleController.createVehicle(vehicleInput);
//
//        // Verify the response
//        assertEquals(HttpStatus.CREATED, response.getStatusCode());
//        assertEquals(1L, response.getBody().getVehicleId());
//    }

    @Test
    public void testGetVehicleById() {
        // Mock the behavior of vehicleService
        VehicleDto mockVehicleDto = new VehicleDto();
        mockVehicleDto.setVehicleId(1L);
        when(vehicleService.getVehicleById(1L)).thenReturn(mockVehicleDto);

        // Call the controller method
        ResponseEntity<VehicleDto> response = vehicleController.getVehicleById(1L);

        // Verify the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1L, response.getBody().getVehicleId());
    }

    @Test
    public void testGetAllVehicles() {
        // Mock the behavior of vehicleService
        List<VehicleDto> mockVehicleList = new ArrayList<>();
        VehicleDto mockVehicleDto = new VehicleDto();
        mockVehicleDto.setVehicleId(1L);
        mockVehicleList.add(mockVehicleDto);
        when(vehicleService.getAllVehicles()).thenReturn(mockVehicleList);

        // Call the controller method
        ResponseEntity<List<VehicleDto>> response = vehicleController.getAllVehicles();

        // Verify the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        assertEquals(1L, response.getBody().get(0).getVehicleId());
    }

    @Test
    public void testUpdateVehicle() {
        // Mock the behavior of vehicleService
        VehicleDto mockVehicleDto = new VehicleDto();
        mockVehicleDto.setVehicleId(1L);
        when(vehicleService.updateVehicle(any(VehicleDto.class), any(Long.class))).thenReturn(mockVehicleDto);

        // Call the controller method
        VehicleDto vehicleInput = new VehicleDto();
        vehicleInput.setVehicleId(1L);
        ResponseEntity<VehicleDto> response = vehicleController.updateVehicle(1L, vehicleInput);

        // Verify the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1L, response.getBody().getVehicleId());
    }

    @Test
    public void testDeleteVehicle() {
        // Call the controller method
        ResponseEntity<String> response = vehicleController.deleteVehicle(1L);

        // Verify the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Vehicle deleted successfully", response.getBody());
    }

//    @Test
//    public void testSuggestVehicle() {
//        // Mock the behavior of vehicleService
//        List<VehicleDto> mockVehicleList = new ArrayList<>();
//        VehicleDto mockVehicleDto = new VehicleDto();
//        mockVehicleDto.setVehicleId(1L);
//        mockVehicleList.add(mockVehicleDto);
//        when(vehicleService.suggestVehicle(any(), any(), any())).thenReturn(mockVehicleList);
//
//        // Call the controller method
//        SuggestVehicleRequest request = new SuggestVehicleRequest();
//        ResponseEntity<?> response = vehicleController.suggestVehicle(request);
//
//        // Verify the response
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(1, ((List<VehicleDto>) response.getBody()).size());
//        assertEquals(1L, ((List<VehicleDto>) response.getBody()).get(0).getVehicleId());
//    }

    // Similar tests for updateVehicle, deleteVehicle, and suggestVehicle can be added here
}
