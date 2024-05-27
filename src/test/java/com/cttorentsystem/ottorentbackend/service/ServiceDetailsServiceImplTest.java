package com.cttorentsystem.ottorentbackend.service;



import com.cttorentsystem.ottorentbackend.controllers.EmailController;
import com.cttorentsystem.ottorentbackend.dtos.ServiceDetailsDto;
import com.cttorentsystem.ottorentbackend.entity.ServiceDetails;
import com.cttorentsystem.ottorentbackend.entity.Vehicle;
import com.cttorentsystem.ottorentbackend.mapper.ServiceDetailsMapper;
import com.cttorentsystem.ottorentbackend.repositorys.ServiceDetailsReporsitory;
import com.cttorentsystem.ottorentbackend.repositorys.VehicleReporsitory;
import com.cttorentsystem.ottorentbackend.service.EmailService;
import com.cttorentsystem.ottorentbackend.service.impl.ServiceDetailsServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ServiceDetailsServiceImplTest {

    @Mock
    ServiceDetailsReporsitory serviceDetailsReporsitory;

    @Mock
    EmailService emailService;

    @Mock
    VehicleReporsitory vehicleReporsitory;

    @InjectMocks
    ServiceDetailsServiceImpl serviceDetailsService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateServiceDetails() {
        // Given
        ServiceDetailsDto serviceDetailsDto = new ServiceDetailsDto();
        serviceDetailsDto.setServiceDetailsId(1L);
        ServiceDetails serviceDetails = ServiceDetailsMapper.mapToServiceDetails(serviceDetailsDto);

        when(serviceDetailsReporsitory.save(any(ServiceDetails.class))).thenReturn(serviceDetails);

        // When
        ServiceDetailsDto savedServiceDetailsDto = serviceDetailsService.createServiceDetails(serviceDetailsDto);

        // Then
        verify(serviceDetailsReporsitory, times(1)).save(any(ServiceDetails.class));
        assert savedServiceDetailsDto != null;
        assertEquals(serviceDetailsDto.getServiceDetailsId(), savedServiceDetailsDto.getServiceDetailsId());
    }

    @Test
    void testTriggerNextServiceDate() {
        // Given
        LocalDate currentDate = LocalDate.now();
        Vehicle vehicle = new Vehicle();
        ServiceDetails serviceDetails = new ServiceDetails();
        serviceDetails.setNextServiceDate(currentDate.plusDays(5)); // Next service in 5 days
        vehicle.setServiceDetails(Collections.singletonList(serviceDetails));
        when(vehicleReporsitory.findAll()).thenReturn(Collections.singletonList(vehicle));

        // When
        serviceDetailsService.triggerNextServiceDate();

        // Then
        verify(emailService, times(1)).sendEmail(anyString(), anyString(), anyString());
    }
}
