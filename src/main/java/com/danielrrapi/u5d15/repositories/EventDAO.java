package com.danielrrapi.u5d15.repositories;

import com.danielrrapi.u5d15.entities.Event;
import com.danielrrapi.u5d15.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventDAO extends JpaRepository<Event, Long> {

}
