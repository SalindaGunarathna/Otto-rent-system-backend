package com.cttorentsystem.ottorentbackend.service;

import com.cttorentsystem.ottorentbackend.dtos.OrderDto;
import com.cttorentsystem.ottorentbackend.entity.Order;
import org.springframework.stereotype.Service;

@Service
public interface EmailBodyGenerator {

    String generateEmailBody(OrderDto order);
}
