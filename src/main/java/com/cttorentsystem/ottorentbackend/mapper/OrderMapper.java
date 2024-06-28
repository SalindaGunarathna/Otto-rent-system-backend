package com.cttorentsystem.ottorentbackend.mapper;

import com.cttorentsystem.ottorentbackend.dtos.OrderDto;
import com.cttorentsystem.ottorentbackend.entity.Order;

public class OrderMapper {

    public static OrderDto mapToOrderDto(Order order) {
        return new OrderDto(
                order.getOrderId(),
                order.getOrderFee(),
                order.getDestination(),
                order.getDistance(),
                order.getPickupDate(),
                order.getPickupTime(),
                order.getOrderStatus(),
                order.getPaymentStatus(),
                order.getRentalDates(),
                order.getNoOfPassengers(),
                order.getNoOfLuggages(),
                order.getDescription(),
                order.getFromAddress(),
                order.getVehicles(),
                UserMapper.mapToUserDto(order.getCustomer()) // Convert User to UserDto
        );
    }

    public static Order mapToOrder(OrderDto orderDto) {
        return new Order(
                orderDto.getOrderId(),
                orderDto.getOrderFee(),
                orderDto.getDestination(),
                orderDto.getDistance(),
                orderDto.getPickupDate(),
                orderDto.getPickupTime(),
                orderDto.getOrderStatus(),
                orderDto.getPaymentStatus(),
                orderDto.getRentalDates(),
                orderDto.getNoOfPassengers(),
                orderDto.getNoOfLuggages(),
                orderDto.getDescription(),
                orderDto.getFromAddress(),
                orderDto.getVehicles(),
                UserMapper.mapToUser(orderDto.getCustomer()) // Convert UserDto to User
        );
    }
}
