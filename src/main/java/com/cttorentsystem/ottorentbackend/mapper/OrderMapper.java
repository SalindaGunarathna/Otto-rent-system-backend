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
                order.getVehicles(),
                order.getCustomer()
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
                orderDto.getVehicles(),
                orderDto.getCustomer()
        );
    }
}
