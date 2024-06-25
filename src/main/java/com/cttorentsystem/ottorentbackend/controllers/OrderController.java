package com.cttorentsystem.ottorentbackend.controllers;


import com.cttorentsystem.ottorentbackend.config.CheckUserAuthorization;
import com.cttorentsystem.ottorentbackend.dtos.OrderDto;
import com.cttorentsystem.ottorentbackend.service.EmailService;
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




    private final  EmailService emailService;

    @PostMapping("/user/createOrder")
    public ResponseEntity<OrderDto> createOrder( @RequestBody OrderDto orderDto) {
        OrderDto newOrder = orderService.createOrder(orderDto);

        OrderDto newOrderDto = null;

        try {
            newOrderDto = orderService.getOrder(newOrder.getOrderId());
            System.out.println(newOrderDto.getCustomer().getFirstName());

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

        EmailController ownerEmailController = new EmailController("Admin-orderUpdate");
        String emailBody = ownerEmailController.generateEmailBody(newOrderDto);
        emailService.sendEmail("salindalakshan99@gmail.com", "New Rent Order", emailBody);

        EmailController customerEmailController = new EmailController("Customer");
        String customerEmailBody = customerEmailController.generateEmailBody(newOrderDto);
        emailService.sendEmail("salinda.eng@gmail.com", "New Rent Order", customerEmailBody);


        return new ResponseEntity<>(newOrderDto, HttpStatus.CREATED);
    }

    @CheckUserAuthorization
    @PutMapping("/user/{userId}")
    public ResponseEntity<OrderDto> updateOrder(@PathVariable("userId") Long userId, @RequestBody OrderDto orderDto) {
        OrderDto updatedOrder = orderService.updateOrder(orderDto);
        if (updatedOrder != null) {
            return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/admin/updateorder")
    public ResponseEntity<OrderDto> updateByAdminOrder( @RequestBody OrderDto orderDto) {
        OrderDto updatedOrder = orderService.updateOrder(orderDto);
        if (updatedOrder != null) {
            return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/user/{orderId}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable("orderId") Long orderId) {
        OrderDto orderDto = orderService.getOrder(orderId);
        return ResponseEntity.ok(orderDto);
    }

    @GetMapping("/admin/all")
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<OrderDto> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @CheckUserAuthorization
    @DeleteMapping("/user/{orderId}/{userId}")
    public ResponseEntity<String> deleteOrder( @PathVariable("userId") Long userId, @PathVariable("orderId") Long orderId) {
            OrderDto deletedOrder = orderService.deleteOrder(orderId);
        return ResponseEntity.ok("Order deleted successfully \n" + deletedOrder.getOrderId());
    }

    @DeleteMapping("/admin/{orderId}")
    public ResponseEntity<String> deleteOrderByAdmin(@PathVariable("orderId") Long orderId) {
        OrderDto deletedOrder = orderService.deleteOrder(orderId);
        return ResponseEntity.ok("Order deleted successfully \n" + deletedOrder);
    }

    @GetMapping("/user/finduserorders/{userId}")
    public ResponseEntity<List<OrderDto>> getOrdersByUserId(@PathVariable("userId") Long userId) {
        List<OrderDto> orders = orderService.getOrdersByUserId(userId);
        return ResponseEntity.ok(orders);
    }



}
