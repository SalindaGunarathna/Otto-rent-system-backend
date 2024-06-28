package com.cttorentsystem.ottorentbackend.entity;

import com.cttorentsystem.ottorentbackend.entity.Order;
import com.cttorentsystem.ottorentbackend.entity.User;
import com.cttorentsystem.ottorentbackend.entity.Vehicle;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OrderTest {

    @Test
    public void testOrderConstructorAndGetters() {
        // Given
        Long orderId = 1L;
        int orderFee = 100;
        String destination = "Test Destination";
        int distance = 50;
        Date pickupDate = new Date();
        String pickupTime = "10:00 AM";
        String orderStatus = "Pending";
        String paymentStatus = "Unpaid";
        String rentalDates = "2024-05-01 to 2024-05-05";
        int noOfPassengers = 2;
        int noOfLuggages = 3;
        String description = "Test Description";
        Vehicle vehicle = new Vehicle();
        User customer = new User();

        // When
        String fromAddress = "Test Address";
        Order order = new Order(orderId, orderFee, destination, distance, pickupDate, pickupTime, orderStatus,
                paymentStatus, rentalDates, noOfPassengers, noOfLuggages, description,fromAddress, vehicle, customer);

        // Then
        assertNotNull(order);
        assertEquals(orderId, order.getOrderId());
        assertEquals(orderFee, order.getOrderFee());
        assertEquals(destination, order.getDestination());
        assertEquals(distance, order.getDistance());
        assertEquals(pickupDate, order.getPickupDate());
        assertEquals(pickupTime, order.getPickupTime());
        assertEquals(orderStatus, order.getOrderStatus());
        assertEquals(paymentStatus, order.getPaymentStatus());
        assertEquals(rentalDates, order.getRentalDates());
        assertEquals(noOfPassengers, order.getNoOfPassengers());
        assertEquals(noOfLuggages, order.getNoOfLuggages());
        assertEquals(description, order.getDescription());
        assertEquals(vehicle, order.getVehicles());
        assertEquals(customer, order.getCustomer());
    }

    // Add more test cases as needed for setters, relationships, etc.
}
