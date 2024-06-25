package com.cttorentsystem.ottorentbackend.repositorys;

import com.cttorentsystem.ottorentbackend.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT o FROM Order o WHERE o.customer.userId = ?1")
    List<Order> findByCustomerUserId(Long userId);
}
