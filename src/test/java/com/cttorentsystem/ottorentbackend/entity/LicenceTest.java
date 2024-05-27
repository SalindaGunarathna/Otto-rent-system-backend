package com.cttorentsystem.ottorentbackend.entity;



import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class LicenceTest {

    @Test
    void testLicenceEntity() {
        // Given
        Long licenceId = 1L;
        Vehicle vehicle = new Vehicle();
        String licenseNumber = "ABC123";
        LocalDate expiryDate = LocalDate.now().plusYears(1);
        LocalDate issueDate = LocalDate.now();
        String issueProvince = "XYZ";

        // When
        Licence licence = new Licence(licenceId, vehicle, licenseNumber, expiryDate, issueDate, issueProvince);

        // Then
        assertNotNull(licence);
        assertEquals(licenceId, licence.getLicenceId());
        assertEquals(vehicle, licence.getVehicleId());
        assertEquals(licenseNumber, licence.getLicenseNumber());
        assertEquals(expiryDate, licence.getExpiryDate());
        assertEquals(issueDate, licence.getIssueDate());
        assertEquals(issueProvince, licence.getIssueProvince());
    }
}
