package com.danielrrapi.u5d15.servicies;

import com.danielrrapi.u5d15.entities.User;
import com.danielrrapi.u5d15.exceptions.NotFoundException;
import com.danielrrapi.u5d15.repositories.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public User findByEmail(String email) {
        return userDAO.findByEmail(email).orElseThrow(() -> new NotFoundException("User with " + email + " not found"));
    }
}
