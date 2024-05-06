package com.cttorentsystem.ottorentbackend.repositorys;

import com.cttorentsystem.ottorentbackend.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
