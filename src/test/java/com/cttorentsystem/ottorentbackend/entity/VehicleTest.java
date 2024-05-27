package com.cttorentsystem.ottorentbackend.entity;



import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class VehicleTest {

    @Test
    void testVehicleEntity() {
        // Given
        Long vehicleId = 1L;
        String registrationNo = "ABC123";
        String vehiclePrice = "$10,000";
        String chassisNumber = "1234567890";
        String engineNo = "ENG123";
        String vehicleState = "Active";
        String companyName = "Company A";
        int numberOfDoors = 4;
        String color = "Black";
        int seatingCapacity = 5;
        String condition = "Excellent";

        Vehicle.Dimensions dimensions = new Vehicle.Dimensions(4.5, 1.8, 2.0);

        int cylinderCapacity = 2000;
        Vehicle.FuelType fuelType = Vehicle.FuelType.Petrol;
        String manufacturedCountry = "Country A";
        boolean assembled = true;
        Vehicle.VehicleType vehicleType = Vehicle.VehicleType.car;
        String brand = "Brand A";
        String style = "Style A";
        String model = "Model A";
        int manufacturedYear = 2022;

        List<Vehicle.Photo> album = new ArrayList<>();
        List<Licence> licenses = new ArrayList<>();
        List<ServiceDetails> serviceDetails = new ArrayList<>();
        List<InsuranceDetails> insuranceDetails = new ArrayList<>();

        // When
        Vehicle vehicle = new Vehicle(vehicleId, registrationNo, vehiclePrice, chassisNumber, engineNo, vehicleState,
                companyName, numberOfDoors, color, seatingCapacity, condition, dimensions, cylinderCapacity,
                fuelType, manufacturedCountry, assembled, vehicleType, brand, style, model, manufacturedYear,
                album, licenses, serviceDetails, insuranceDetails);

        // Then
        assertNotNull(vehicle);
        assertEquals(vehicleId, vehicle.getVehicleId());
        assertEquals(registrationNo, vehicle.getRegistrationNo());
        assertEquals(vehiclePrice, vehicle.getVehiclePrice());
        assertEquals(chassisNumber, vehicle.getChassisNumber());
        assertEquals(engineNo, vehicle.getEngineNo());
        assertEquals(vehicleState, vehicle.getVehicleState());
        assertEquals(companyName, vehicle.getCompanyName());
        assertEquals(numberOfDoors, vehicle.getNumberOfDoors());
        assertEquals(color, vehicle.getColor());
        assertEquals(seatingCapacity, vehicle.getSeatingCapacity());
        assertEquals(condition, vehicle.getCondition());
        assertEquals(dimensions, vehicle.getDimensions());
        assertEquals(cylinderCapacity, vehicle.getCylinderCapacity());
        assertEquals(fuelType, vehicle.getFuelType());
        assertEquals(manufacturedCountry, vehicle.getManufacturedCountry());
        assertEquals(assembled, vehicle.isAssembled());
        assertEquals(vehicleType, vehicle.getVehicleType());
        assertEquals(brand, vehicle.getBrand());
        assertEquals(style, vehicle.getStyle());
        assertEquals(model, vehicle.getModel());
        assertEquals(manufacturedYear, vehicle.getManufacturedYear());
        assertEquals(album, vehicle.getAlbum());
        assertEquals(licenses, vehicle.getLicenses());
        assertEquals(serviceDetails, vehicle.getServiceDetails());
        assertEquals(insuranceDetails, vehicle.getInsuranceDetails());
    }
}
