package com.cttorentsystem.ottorentbackend.controller;

import com.cttorentsystem.ottorentbackend.controllers.OrderController;
import com.cttorentsystem.ottorentbackend.dtos.OrderDto;
import com.cttorentsystem.ottorentbackend.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderControllerTest {

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateOrder() {
        // Mock the behavior of orderService
        OrderDto mockOrderDto = new OrderDto();
        mockOrderDto.setOrderId(1L);
        when(orderService.createOrder(any(OrderDto.class))).thenReturn(mockOrderDto);

        // Call the controller method
        OrderDto orderInput = new OrderDto();
        orderInput.setOrderId(1L);
        ResponseEntity<OrderDto> response = orderController.createOrder(orderInput);

        // Verify the response
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(1L, response.getBody().getOrderId());
    }

//    @Test
//    public void testUpdateOrder() {
//        // Mock the behavior of orderService
//        OrderDto orderDto = new OrderDto();
//        orderDto.setOrderId(1L);
//        when(orderService.updateOrder(any(OrderDto.class), eq(1L))).thenReturn(orderDto);
//
//        // Call the controller method
//        ResponseEntity<OrderDto> response = orderController.updateOrder(1L, orderDto);
//
//        // Verify the response
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(1L, response.getBody().getOrderId());
//    }

    @Test
    public void testGetOrder() {
        // Mock the behavior of orderService
        OrderDto mockOrderDto = new OrderDto();
        mockOrderDto.setOrderId(1L);
        when(orderService.getOrder(1L)).thenReturn(mockOrderDto);

        // Call the controller method
        ResponseEntity<OrderDto> response = orderController.getOrder(1L);

        // Verify the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1L, response.getBody().getOrderId());
    }

    @Test
    public void testGetAllOrders() {
        // Mock the behavior of orderService
        List<OrderDto> mockOrderList = new ArrayList<>();
        OrderDto order1 = new OrderDto();
        order1.setOrderId(1L);
        mockOrderList.add(order1);
        when(orderService.getAllOrders()).thenReturn(mockOrderList);

        // Call the controller method
        ResponseEntity<List<OrderDto>> response = orderController.getAllOrders();

        // Verify the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        assertEquals(1L, response.getBody().get(0).getOrderId());
    }

//    @Test
//    public void testDeleteOrder() {
//        // Mock the behavior of orderService
//        OrderDto mockOrderDto = new OrderDto();
//        mockOrderDto.setOrderId(1L);
//        when(orderService.deleteOrder(1L)).thenReturn(mockOrderDto);
//
//        // Call the controller method
//        ResponseEntity<String> response = orderController.deleteOrder(1L);
//
//        // Verify the response
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals("Order deleted successfully \n" + mockOrderDto, response.getBody());
//    }
}

