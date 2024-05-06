package com.cttorentsystem.ottorentbackend.service.impl;

import com.cttorentsystem.ottorentbackend.dtos.OrderDto;
import com.cttorentsystem.ottorentbackend.entity.Order;
import com.cttorentsystem.ottorentbackend.mapper.OrderMapper;
import com.cttorentsystem.ottorentbackend.repositorys.OrderRepository;
import com.cttorentsystem.ottorentbackend.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    @Override
    public OrderDto createOrder(OrderDto orderDto) {

        Order order = OrderMapper.mapToOrder(orderDto);

        Order saveOrder = orderRepository.save(order);
        return OrderMapper.mapToOrderDto(saveOrder);

    }



    @Override
    public OrderDto updateOrder(OrderDto orderDto, Long orderId) {

        Order oldOrder = orderRepository.findById(orderId).orElseThrow(() ->
                new IllegalArgumentException("Order not found with id : " + orderId));

        oldOrder.setOrderFee(orderDto.getOrderFee());
        oldOrder.setDestination(orderDto.getDestination());
        oldOrder.setDistance(orderDto.getDistance());
        oldOrder.setPickupDate(orderDto.getPickupDate());
        oldOrder.setPickupTime(orderDto.getPickupTime());
        oldOrder.setOrderStatus(orderDto.getOrderStatus());
        oldOrder.setPaymentStatus(orderDto.getPaymentStatus());
        oldOrder.setRentalDates(orderDto.getRentalDates());
        oldOrder.setVehicles(orderDto.getVehicles());
        oldOrder.setCustomer(orderDto.getCustomer());

        Order saveOrder = orderRepository.save(oldOrder);
        return OrderMapper.mapToOrderDto(saveOrder);

    }

    @Override
    public OrderDto getOrder(Long orderId) {

        Order order = orderRepository.findById(orderId).orElseThrow(() ->
                new IllegalArgumentException("Order not found with id : " + orderId));
        return OrderMapper.mapToOrderDto(order);

    }

    @Override
    public List<OrderDto> getAllOrders() {

        List<Order> orderList = orderRepository.findAll();

        return orderList.stream().map(OrderMapper::mapToOrderDto).toList();

    }

    @Override
    public OrderDto deleteOrder(Long orderId) {

        Order order = orderRepository.findById(orderId).orElseThrow(() ->
                new IllegalArgumentException("Order not found with id : " + orderId));

        orderRepository.deleteById(orderId);

        return OrderMapper.mapToOrderDto(order);


    }
}
