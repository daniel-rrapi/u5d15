package com.danielrrapi.u5d15.servicies;

import com.danielrrapi.u5d15.repositories.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserService userService;
    @Autowired
    private UserDAO userDAO;
}
