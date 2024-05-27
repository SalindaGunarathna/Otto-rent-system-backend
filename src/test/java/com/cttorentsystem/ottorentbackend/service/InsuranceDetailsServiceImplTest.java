package com.cttorentsystem.ottorentbackend.service;



import com.cttorentsystem.ottorentbackend.controllers.EmailController;
import com.cttorentsystem.ottorentbackend.dtos.InsuranceDetailsDto;
import com.cttorentsystem.ottorentbackend.entity.InsuranceDetails;
import com.cttorentsystem.ottorentbackend.entity.Vehicle;
import com.cttorentsystem.ottorentbackend.mapper.InsuranceDetailsMapper;
import com.cttorentsystem.ottorentbackend.repositorys.InsuranceDetailsReporsitory;
import com.cttorentsystem.ottorentbackend.repositorys.VehicleReporsitory;
import com.cttorentsystem.ottorentbackend.service.EmailService;
import com.cttorentsystem.ottorentbackend.service.impl.InsuranceDetailsServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class InsuranceDetailsServiceImplTest {

    @Mock
    InsuranceDetailsReporsitory insuranceDetailsReporsitory;

    @Mock
    EmailService emailService;

    @Mock
    VehicleReporsitory vehicleReporsitory;

    @InjectMocks
    InsuranceDetailsServiceImpl insuranceDetailsService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddInsuranceDetails() {
        // Given
        InsuranceDetailsDto insuranceDetailsDto = new InsuranceDetailsDto();
        insuranceDetailsDto.setInsuranceDetailsId(1L);
        InsuranceDetails insuranceDetails = InsuranceDetailsMapper.mapToInsuranceDetails(insuranceDetailsDto);

        when(insuranceDetailsReporsitory.save(any(InsuranceDetails.class))).thenReturn(insuranceDetails);

        // When
        InsuranceDetailsDto savedInsuranceDetailsDto = insuranceDetailsService.addInsuranceDetails(insuranceDetailsDto);

        // Then
        verify(insuranceDetailsReporsitory, times(1)).save(any(InsuranceDetails.class));
        assert savedInsuranceDetailsDto != null;
        assertEquals(insuranceDetailsDto.getInsuranceDetailsId(), savedInsuranceDetailsDto.getInsuranceDetailsId());
    }

    @Test
    void testTriggerInsuranceExpiryDateDate() {
        // Given
        LocalDate currentDate = LocalDate.now();
        Vehicle vehicle = new Vehicle();
        InsuranceDetails insuranceDetails = new InsuranceDetails();
        insuranceDetails.setRenewalDate(currentDate.plusDays(5)); // Expires in 5 days
        vehicle.setInsuranceDetails(Collections.singletonList(insuranceDetails));
        when(vehicleReporsitory.findAll()).thenReturn(Collections.singletonList(vehicle));

        // When
        insuranceDetailsService.triggerInsuranceExpiryDateDate();

        // Then
        verify(emailService, times(1)).sendEmail(anyString(), anyString(), anyString());
    }
}
