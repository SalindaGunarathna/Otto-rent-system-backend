package com.cttorentsystem.ottorentbackend.entity;


import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class InsuranceDetailsTest {

    @Test
    void testInsuranceDetailsEntity() {
        // Given
        Long insuranceDetailsId = 1L;
        String coverageType = "Comprehensive";
        String companyName = "InsuranceCo";
        String policyholderName = "John Doe";
        String coveragePeriod = "1 year";
        Vehicle vehicleDetails = new Vehicle();
        String premiumAmount = "1000";
        String policyExclusions = "Exclusions here";
        LocalDate renewalDate = LocalDate.now().plusYears(1);
        String contactNumber = "1234567890";
        String claimProcess = "Process details here";

        // When
        InsuranceDetails insuranceDetails = new InsuranceDetails(insuranceDetailsId, coverageType, companyName,
                policyholderName, coveragePeriod, vehicleDetails, premiumAmount, policyExclusions, renewalDate,
                contactNumber, claimProcess);

        // Then
        assertNotNull(insuranceDetails);
        assertEquals(insuranceDetailsId, insuranceDetails.getInsuranceDetailsId());
        assertEquals(coverageType, insuranceDetails.getCoverageType());
        assertEquals(companyName, insuranceDetails.getCompanyName());
        assertEquals(policyholderName, insuranceDetails.getPolicyholderName());
        assertEquals(coveragePeriod, insuranceDetails.getCoveragePeriod());
        assertEquals(vehicleDetails, insuranceDetails.getVehicleDetails());
        assertEquals(premiumAmount, insuranceDetails.getPremiumAmount());
        assertEquals(policyExclusions, insuranceDetails.getPolicyExclusions());
        assertEquals(renewalDate, insuranceDetails.getRenewalDate());
        assertEquals(contactNumber, insuranceDetails.getContactNumber());
        assertEquals(claimProcess, insuranceDetails.getClaimProcess());
    }
}
