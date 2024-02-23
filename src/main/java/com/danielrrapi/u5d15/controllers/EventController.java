package com.danielrrapi.u5d15.controllers;

import com.danielrrapi.u5d15.entities.Event;
import com.danielrrapi.u5d15.entities.User;
import com.danielrrapi.u5d15.payloads.EventIdDTO;
import com.danielrrapi.u5d15.payloads.NewEventDTO;
import com.danielrrapi.u5d15.servicies.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")
public class EventController {
    @Autowired
    private EventService eventService;

    @GetMapping("/{id}")
    public Event findById(@PathVariable long id) {
        return eventService.findById(id);
    }

    @PostMapping()
    @PreAuthorize("hasAuthority('EVENT_MANAGER')")
    public Event addEvent(@AuthenticationPrincipal User currentUser, @RequestBody NewEventDTO payload) {
        return  eventService.saveEvent(payload);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('EVENT_MANAGER')")
    public Event findEventByIdAndUpdate(@PathVariable long id, @RequestBody NewEventDTO payload) {
        return eventService.findByIdAndUpdate(id, payload);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('EVENT_MANAGER')")
    public void findByIdAndDelete(@PathVariable long id) {
        eventService.findByAndDeleteEvent(id);
    }

    @PostMapping("/booking")
    public Event participateToEvent(@RequestBody EventIdDTO payload, @AuthenticationPrincipal User currentUser) {
        return eventService.addUserToEvent(payload.id(), currentUser);
    }


}
