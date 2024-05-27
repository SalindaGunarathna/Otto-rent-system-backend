package com.cttorentsystem.ottorentbackend.service;



import com.cttorentsystem.ottorentbackend.dtos.LicenceDto;
import com.cttorentsystem.ottorentbackend.entity.Licence;
import com.cttorentsystem.ottorentbackend.entity.Vehicle;
import com.cttorentsystem.ottorentbackend.mapper.LicenceMapper;
import com.cttorentsystem.ottorentbackend.repositorys.LicenceRepository;
import com.cttorentsystem.ottorentbackend.repositorys.VehicleReporsitory;
import com.cttorentsystem.ottorentbackend.service.EmailService;
import com.cttorentsystem.ottorentbackend.service.impl.LicenceServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class LicenceServiceImplTest {

    @Mock
    LicenceRepository licenceRepository;

    @Mock
    EmailService emailService;

    @Mock
    VehicleReporsitory vehicleReporsitory;

    @InjectMocks
    LicenceServiceImpl licenceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateLicence() {
        // Given
        LicenceDto licenceDto = new LicenceDto();
        licenceDto.setLicenceId(1L);
        licenceDto.setLicenseNumber("ABC123");
        Licence licence = LicenceMapper.mapToLicence(licenceDto);

        when(licenceRepository.save(any(Licence.class))).thenReturn(licence);

        // When
        LicenceDto savedLicenceDto = licenceService.createLicence(licenceDto);

        // Then
        verify(licenceRepository, times(1)).save(any(Licence.class));
        assert savedLicenceDto != null;
        assertEquals(licenceDto.getLicenceId(), savedLicenceDto.getLicenceId());
        assertEquals(licenceDto.getLicenseNumber(), savedLicenceDto.getLicenseNumber());
    }

    @Test
    void testTriggerLicenceExpiryDateDate() {
        // Given
        LocalDate currentDate = LocalDate.now();
        Vehicle vehicle = new Vehicle();
        Licence licence = new Licence();
        licence.setExpiryDate(currentDate.plusDays(5)); // Expire in 5 days
        vehicle.setLicenses(Arrays.asList(licence));
        when(vehicleReporsitory.findAll()).thenReturn(Arrays.asList(vehicle));

        // When
        licenceService.triggerLicenceExpiryDateDate();

        // Then
        verify(emailService, times(1)).sendEmail(anyString(), anyString(), anyString());
    }
}
