package com.cttorentsystem.ottorentbackend.service.impl;

import com.cttorentsystem.ottorentbackend.dtos.OrderDto;
import com.cttorentsystem.ottorentbackend.entity.Order;
import com.cttorentsystem.ottorentbackend.entity.User;
import com.cttorentsystem.ottorentbackend.mapper.OrderMapper;
import com.cttorentsystem.ottorentbackend.mapper.UserMapper;
import com.cttorentsystem.ottorentbackend.repositorys.OrderRepository;
import com.cttorentsystem.ottorentbackend.repositorys.UserReporsitory;
import com.cttorentsystem.ottorentbackend.service.OrderService;
import lombok.AllArgsConstructor;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private UserReporsitory userReporsitory;
    @Override
    @Transactional
    public OrderDto createOrder(OrderDto orderDto) {

        Order order = OrderMapper.mapToOrder(orderDto);

        Order saveOrder = orderRepository.save(order);
        System.out.println(saveOrder.getOrderId());
        return OrderMapper.mapToOrderDto(saveOrder);

    }



    @Override
    public OrderDto updateOrder(OrderDto orderDto) {

        Order oldOrder = orderRepository.findById(orderDto.getOrderId()).orElseThrow(() ->
                new IllegalArgumentException("Order not found with id : " + orderDto.getOrderId()));

        oldOrder.setOrderFee(orderDto.getOrderFee());
        oldOrder.setDestination(orderDto.getDestination());
        oldOrder.setDistance(orderDto.getDistance());
        oldOrder.setPickupDate(orderDto.getPickupDate());
        oldOrder.setPickupTime(orderDto.getPickupTime());
        oldOrder.setOrderStatus(orderDto.getOrderStatus());
        oldOrder.setPaymentStatus(orderDto.getPaymentStatus());
        oldOrder.setRentalDates(orderDto.getRentalDates());
        oldOrder.setVehicles(orderDto.getVehicles());
        oldOrder.setCustomer(UserMapper.mapToUser(orderDto.getCustomer()));

        Order saveOrder = orderRepository.save(oldOrder);
        return OrderMapper.mapToOrderDto(saveOrder);

    }

    @Override
    @Transactional(readOnly = true)
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

        // Get the customer associated with the order
        User customer = order.getCustomer();

        if (customer != null) {
            // Remove the order from the customer's orders list
            customer.getOrders().remove(order);
            // Save the updated customer entity

            userReporsitory.save(customer);
        }

        // Delete the order from the database
        orderRepository.delete(order);

        //orderRepository.deleteById(orderId);

        return OrderMapper.mapToOrderDto(order);


    }

    @Override
    public List<OrderDto> getOrdersByUserId(Long userId) {

           List<Order> orders = orderRepository.findByCustomerUserId(userId);
           return orders.stream().map(OrderMapper::mapToOrderDto).toList();
    }


}
