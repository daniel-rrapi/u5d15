package com.danielrrapi.u5d15.controllers;

import com.danielrrapi.u5d15.entities.Event;
import com.danielrrapi.u5d15.entities.User;
import com.danielrrapi.u5d15.servicies.EventService;
import com.danielrrapi.u5d15.servicies.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private EventService eventService;

    @Autowired
    private UserService userService;

    @GetMapping("/me")
    public User getProfile(@AuthenticationPrincipal User currentAuthenticatedUser) {
        return currentAuthenticatedUser;
    }



}
