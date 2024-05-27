package com.cttorentsystem.ottorentbackend.entity;



import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ServiceDetailsTest {

    @Test
    void testServiceDetailsEntity() {
        // Given
        Long serviceDetailsId = 1L;
        LocalDate serviceDate = LocalDate.now();
        String serviceCenterName = "Service Center A";
        String serviceCenterLocation = "Location A";
        String travelDistance = "100 km";
        String serviceCost = "$200";
        Vehicle vehicleId = new Vehicle();
        List<ChangedPart> changedParts = new ArrayList<>();
        String driverName = "John Doe";
        String driverPhone = "123-456-7890";
        LocalDate nextServiceDate = LocalDate.now().plusMonths(1);
        String nextServiceDistance = "150 km";

        // When
        ServiceDetails serviceDetails = new ServiceDetails(serviceDetailsId, serviceDate, serviceCenterName,
                serviceCenterLocation, travelDistance, serviceCost, vehicleId, changedParts, driverName, driverPhone,
                nextServiceDate, nextServiceDistance);

        // Then
        assertNotNull(serviceDetails);
        assertEquals(serviceDetailsId, serviceDetails.getServiceDetailsId());
        assertEquals(serviceDate, serviceDetails.getServiceDate());
        assertEquals(serviceCenterName, serviceDetails.getServiceCenterName());
        assertEquals(serviceCenterLocation, serviceDetails.getServiceCenterLocation());
        assertEquals(travelDistance, serviceDetails.getTravelDistance());
        assertEquals(serviceCost, serviceDetails.getServiceCost());
        assertEquals(vehicleId, serviceDetails.getVehicleId());
        assertEquals(changedParts, serviceDetails.getChangedParts());
        assertEquals(driverName, serviceDetails.getDriverName());
        assertEquals(driverPhone, serviceDetails.getDriverPhone());
        assertEquals(nextServiceDate, serviceDetails.getNextServiceDate());
        assertEquals(nextServiceDistance, serviceDetails.getNextServiceDistance());
    }
}
