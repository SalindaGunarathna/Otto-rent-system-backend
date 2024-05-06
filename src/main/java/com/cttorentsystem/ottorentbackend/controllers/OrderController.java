package com.cttorentsystem.ottorentbackend.controllers;


import com.cttorentsystem.ottorentbackend.dtos.OrderDto;
import com.cttorentsystem.ottorentbackend.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderDto> createOrder( @RequestBody OrderDto orderDto) {
       OrderDto newOrder = orderService.createOrder(orderDto);

       return  new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }

    @PostMapping("/{orderId}")
    public ResponseEntity<OrderDto> updateOrder(@PathVariable("orderId") Long orderId, @RequestBody OrderDto orderDto) {
        OrderDto updatedOrder = orderService.updateOrder(orderDto, orderId);

        return ResponseEntity.ok(updatedOrder);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable("orderId") Long orderId) {
        OrderDto orderDto = orderService.getOrder(orderId);
        return ResponseEntity.ok(orderDto);
    }

    @GetMapping("/all")
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<OrderDto> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<String> deleteOrder(@PathVariable("orderId") Long orderId) {
            OrderDto deletedOrder = orderService.deleteOrder(orderId);
        return ResponseEntity.ok("Order deleted successfully \n" + deletedOrder);
    }

}
