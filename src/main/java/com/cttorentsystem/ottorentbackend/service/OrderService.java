package com.cttorentsystem.ottorentbackend.service;

import com.cttorentsystem.ottorentbackend.dtos.OrderDto;

import java.util.List;

public interface OrderService {

     OrderDto createOrder(OrderDto orderDto);



    OrderDto updateOrder(OrderDto orderDto, Long orderId);

    OrderDto getOrder(Long orderId);

     List<OrderDto> getAllOrders();

     OrderDto deleteOrder(Long orderId);
}
