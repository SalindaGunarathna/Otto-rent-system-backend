package com.cttorentsystem.ottorentbackend.service;

import com.cttorentsystem.ottorentbackend.dtos.VehicleDto;
import com.cttorentsystem.ottorentbackend.entity.Vehicle;
import com.cttorentsystem.ottorentbackend.exception.ResourceNotFoundException;
import com.cttorentsystem.ottorentbackend.mapper.VehicleMapper;
import com.cttorentsystem.ottorentbackend.repositorys.VehicleReporsitory;
import com.cttorentsystem.ottorentbackend.service.impl.VehicleServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class VehicleServiceImplTest {

    @Mock
    private VehicleReporsitory vehicleReporsitory;

    @InjectMocks
    private VehicleServiceImpl vehicleServiceImpl;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

//    @Test
//    public void testCreateVehicle() {
//        // Given
//        VehicleDto vehicleDto = new VehicleDto();
//        Vehicle vehicle = new Vehicle();
//        when(vehicleReporsitory.save(any(Vehicle.class))).thenReturn(vehicle);
//
//        // When
//        VehicleDto savedVehicleDto = vehicleServiceImpl.createVehicle(vehicleDto);
//
//        // Then
//        assertNotNull(savedVehicleDto);
//        verify(vehicleReporsitory, times(1)).save(any(Vehicle.class));
//    }

//    @Test
//    public void testGetVehicleById() {
//        // Given
//        Long vehicleId = 1L;
//        Vehicle vehicle = new Vehicle();
//        vehicle.setVehicleId(vehicleId);
//        when(vehicleReporsitory.findById(vehicleId)).thenReturn(Optional.of(vehicle));
//
//        // When
//        VehicleDto retrievedVehicleDto = vehicleServiceImpl.getVehicleById(vehicleId);
//
//        // Then
//        assertNotNull(retrievedVehicleDto);
//        assertEquals(vehicleId, retrievedVehicleDto.getVehicleId());
//        verify(vehicleReporsitory, times(1)).findById(vehicleId);
//    }

    @Test
    public void testGetVehicleById_ResourceNotFoundException() {
        // Given
        Long vehicleId = 1L;
        when(vehicleReporsitory.findById(vehicleId)).thenReturn(Optional.empty());

        // When - Then
        assertThrows(ResourceNotFoundException.class, () -> vehicleServiceImpl.getVehicleById(vehicleId));
        verify(vehicleReporsitory, times(1)).findById(vehicleId);
    }

    @Test
    public void testGetAllVehicles() {
        // Given
        List<Vehicle> vehicleList = new ArrayList<>();
        when(vehicleReporsitory.findAll()).thenReturn(vehicleList);

        // When
        List<VehicleDto> allVehiclesDto = vehicleServiceImpl.getAllVehicles();

        // Then
        assertNotNull(allVehiclesDto);
        assertEquals(0, allVehiclesDto.size());
        verify(vehicleReporsitory, times(1)).findAll();
    }

    // Similar tests for updateVehicle, deleteVehicle, and suggestVehicle methods
}

