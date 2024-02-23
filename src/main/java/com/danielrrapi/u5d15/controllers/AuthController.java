package com.danielrrapi.u5d15.controllers;

import com.danielrrapi.u5d15.entities.User;
import com.danielrrapi.u5d15.payloads.LoginResponseDTO;
import com.danielrrapi.u5d15.payloads.NewUserDTO;
import com.danielrrapi.u5d15.payloads.UserLoginDTO;
import com.danielrrapi.u5d15.servicies.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody UserLoginDTO payload) {
        return new LoginResponseDTO(authService.authenticateUserAndGenerateToken(payload));
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody NewUserDTO payload) {
        return this.authService.saveUser(payload);
    }
}
