package com.cttorentsystem.ottorentbackend.repositorys;


import com.cttorentsystem.ottorentbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReporsitory extends JpaRepository<User, Long> {
}
