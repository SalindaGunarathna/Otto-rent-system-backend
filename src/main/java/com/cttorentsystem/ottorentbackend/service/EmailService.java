package com.cttorentsystem.ottorentbackend.service;

import com.cttorentsystem.ottorentbackend.entity.Order;
import org.springframework.stereotype.Service;

@Service
public interface EmailService {


    void sendEmail(String to, String subject, String body);



}
