package com.cttorentsystem.ottorentbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vehicle")
public class Vehicle {

    @Id
    private String vehicleId;
    private String vehiclePrice;
    private String chassisNumber;
    private String engineNo;
    private String vehicleState;
    private String companyName;
    private int numberOfDoors;
    private String color;
    private int seatingCapacity;
    private String condition;

    @Embedded
    private Dimensions dimensions;

    private int cylinderCapacity;
    @Enumerated(EnumType.STRING)
    private FuelType fuelType;
    private String manufacturedCountry;
    private boolean assembled;

    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    private String brand;
    private String style;
    private String model;
    private int manufacturedYear;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Photo> album;

    @Embeddable
    public static class Dimensions {
        private double length;
        private double height;
        private double width;

        // Constructor, getters, and setters
    }

    public enum FuelType {
        Petrol, Diesel, Electric, Hybrid, CNG
    }

    public enum VehicleType {
        car, bike, van, truck, cab
    }

    @Entity
    @Table(name = "photo")
    public static class Photo {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String photoURL;
        private String photoID;

        // Constructor, getters, and setters
    }
}
