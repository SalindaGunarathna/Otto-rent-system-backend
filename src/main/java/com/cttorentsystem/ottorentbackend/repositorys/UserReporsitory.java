package com.cttorentsystem.ottorentbackend.repositorys;

import com.cttorentsystem.ottorentbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserReporsitory extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
