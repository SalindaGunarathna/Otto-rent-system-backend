package com.cttorentsystem.ottorentbackend.service.impl;

import com.cttorentsystem.ottorentbackend.dtos.OrderDto;
import com.cttorentsystem.ottorentbackend.entity.Order;
import com.cttorentsystem.ottorentbackend.service.EmailBodyGenerator;
import com.cttorentsystem.ottorentbackend.service.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;


    @Override
    public void sendEmail(String toEmail, String subject, String body) {
        System.out.println("Email sent to " + toEmail + " with subject: " + subject + " and body: " + body);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);

    }




}
