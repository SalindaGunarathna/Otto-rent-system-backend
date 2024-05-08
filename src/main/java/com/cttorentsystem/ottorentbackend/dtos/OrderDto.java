package com.cttorentsystem.ottorentbackend.dtos;

import com.cttorentsystem.ottorentbackend.entity.User;
import com.cttorentsystem.ottorentbackend.entity.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long orderId;
    private int orderFee;
    private String Destination;
    private int distance;
    private Date pickupDate;
    private String pickupTime;
    private String orderStatus;
    private String paymentStatus;
    private String rentalDates;

    private Vehicle vehicles;

    private User customer;
}
