package com.danielrrapi.u5d15.servicies;

import com.danielrrapi.u5d15.entities.Event;
import com.danielrrapi.u5d15.entities.User;
import com.danielrrapi.u5d15.exceptions.BadRequestException;
import com.danielrrapi.u5d15.exceptions.NotFoundException;
import com.danielrrapi.u5d15.repositories.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private EventService eventService;

    public User findByEmail(String email) {
        return userDAO.findByEmail(email).orElseThrow(() -> new NotFoundException("User with " + email + " not found"));
    }

    public User findById(long id) {
        return userDAO.findById(id).orElseThrow(() -> new NotFoundException("User with id: " + id + " not found"));
    }

}
