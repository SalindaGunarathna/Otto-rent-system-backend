package com.cttorentsystem.ottorentbackend.repositorys;

import com.cttorentsystem.ottorentbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserReporsitory extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
