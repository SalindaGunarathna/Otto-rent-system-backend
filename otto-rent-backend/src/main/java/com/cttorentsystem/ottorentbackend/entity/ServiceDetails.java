package com.cttorentsystem.ottorentbackend.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor@NoArgsConstructor
@Table(name = "service_details")
public class ServiceDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceId;

    private Date serviceDate;
    private String serviceType;
    private String serviceCenterName;
    private String serviceCenterAddress;
    private String serviceCenterPhone;
    private String serviceCenterEmail;
    private String travelDistance;
    private String serviceCost;
    private String serviceDoneBy;
    private Date serviceCompletionDate;

    @OneToMany(mappedBy = "serviceDetails", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChangedPart> changedParts = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "vehicle_id", referencedColumnName = "vehicleId")
    @JsonIgnore
    private Vehicle vehicle;

    private String serviceDescription;
}
