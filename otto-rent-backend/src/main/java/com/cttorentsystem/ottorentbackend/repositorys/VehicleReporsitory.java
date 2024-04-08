package com.cttorentsystem.ottorentbackend.repositorys;

import com.cttorentsystem.ottorentbackend.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleReporsitory extends JpaRepository<Vehicle, Long> {
}
