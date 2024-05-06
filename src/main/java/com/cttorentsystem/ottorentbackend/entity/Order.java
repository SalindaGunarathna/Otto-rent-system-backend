package com.cttorentsystem.ottorentbackend.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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
@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private int orderFee;
    private String Destination;
    private int distance;
    private Date pickupDate;
    private String pickupTime;
    private String orderStatus;
    private String paymentStatus;
    private String rentalDates;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicles;


    @ManyToOne
    @JoinColumn(name = "customer", referencedColumnName = "user_id")
    @JsonIgnore
    private User customer;



}
