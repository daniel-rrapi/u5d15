package com.danielrrapi.u5d15.servicies;

import com.danielrrapi.u5d15.entities.Event;
import com.danielrrapi.u5d15.exceptions.NotFoundException;
import com.danielrrapi.u5d15.payloads.NewEventDTO;
import com.danielrrapi.u5d15.repositories.EventDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    @Autowired
    private EventDAO eventDAO;

    public Event findById(long id) {
        return eventDAO.findById(id).orElseThrow(() -> new NotFoundException("Event with id: "+ id + " not found"));
    }

    public Event saveEvent(NewEventDTO payload) {
        Event newEvent = new Event(payload.name(), payload.description(), payload.date(), payload.location(), payload.seats());
        return eventDAO.save(newEvent);
    }

    public Event findByIdAndUpdate(long id, NewEventDTO payload) {
        Event found = this.findById(id);
        found.setName(payload.name());
        found.setDescription(payload.description());
        found.setDate(payload.date());
        found.setLocation(payload.location());
        found.setSeats(payload.seats());
        return eventDAO.save(found);
    }

    public void findByAndDeleteEvent(long id) {
        Event event = this.findById(id);
        eventDAO.delete(event);
    }
}
