package com.cttorentsystem.ottorentbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "changed_parts")
public class ChangedPart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long part_id;

    @ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "serviceId")
    @JsonIgnore
    private ServiceDetails serviceDetails;

    private String partName;

    private String partPrice;

    private String partDescription;


}

