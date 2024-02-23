package com.danielrrapi.u5d15.payloads;

import com.danielrrapi.u5d15.entities.User;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.List;

public record NewEventDTO(
        @NotBlank
        String name,
        @NotBlank
        String description,
        @NotBlank
        LocalDate date,
        @NotBlank
        String location,
        @NotBlank
        int seats
) {
}
