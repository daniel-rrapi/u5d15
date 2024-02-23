package com.danielrrapi.u5d15.repositories;

import com.danielrrapi.u5d15.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDAO extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
