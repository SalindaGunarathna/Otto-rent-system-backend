package com.cttorentsystem.ottorentbackend.service;

import com.cttorentsystem.ottorentbackend.dtos.OrderDto;
import com.cttorentsystem.ottorentbackend.entity.Order;
import com.cttorentsystem.ottorentbackend.mapper.OrderMapper;
import com.cttorentsystem.ottorentbackend.repositorys.OrderRepository;
import com.cttorentsystem.ottorentbackend.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class OrderServiceImplTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderServiceImpl orderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreateOrder() {
        // Given
        OrderDto orderDto = new OrderDto();
        Order order = new Order();
        when(orderRepository.save(any(Order.class))).thenReturn(order);

        // When
        OrderDto result = orderService.createOrder(orderDto);

        // Then
        verify(orderRepository, times(1)).save(any(Order.class));
        assertEquals(orderDto, result);
    }

//    @Test
//    void testUpdateOrder() {
//        // Given
//        Long orderId = 1L;
//        OrderDto orderDto = new OrderDto();
//        Order order = new Order();
//        when(orderRepository.findById(orderId)).thenReturn(Optional.of(order));
//        when(orderRepository.save(any(Order.class))).thenReturn(order);
//
//        // When
//        OrderDto result = orderService.updateOrder(orderDto, orderId);
//
//        // Then
//        verify(orderRepository, times(1)).findById(orderId);
//        verify(orderRepository, times(1)).save(any(Order.class));
//        assertEquals(orderDto, result);
//    }

    @Test
    void testGetOrder() {
        // Given
        Long orderId = 1L;
        Order order = new Order();
        when(orderRepository.findById(orderId)).thenReturn(Optional.of(order));

        // When
        OrderDto result = orderService.getOrder(orderId);

        // Then
        verify(orderRepository, times(1)).findById(orderId);
        assertEquals(OrderMapper.mapToOrderDto(order), result);
    }

    @Test
    void testGetAllOrders() {
        // Given
        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order());
        orderList.add(new Order());
        when(orderRepository.findAll()).thenReturn(orderList);

        // When
        List<OrderDto> result = orderService.getAllOrders();

        // Then
        verify(orderRepository, times(1)).findAll();
        assertEquals(orderList.size(), result.size());
    }

    @Test
    void testDeleteOrder() {
        // Given
        Long orderId = 1L;
        Order order = new Order();
        when(orderRepository.findById(orderId)).thenReturn(Optional.of(order));

        // When
        OrderDto result = orderService.deleteOrder(orderId);

        // Then
        verify(orderRepository, times(1)).findById(orderId);
        verify(orderRepository, times(1)).deleteById(orderId);
        assertEquals(OrderMapper.mapToOrderDto(order), result);
    }
}

