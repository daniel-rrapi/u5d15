package com.danielrrapi.u5d15.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record NewUserDTO(
        @NotBlank(message = "Name is obbligatory")
        String name,
        @NotBlank(message = "Surname is obbligatory")
        String surname,
        @NotBlank(message = "Email is obbligatory")
        @Email(message = "Insert a valid email")
        String email,
        @NotBlank(message = "Password is obbligatory")
        String password
) {
}
