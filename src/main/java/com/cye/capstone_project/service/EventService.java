package com.cye.capstone_project.service;

import com.cye.capstone_project.model.Event;
import com.cye.capstone_project.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event updateEvent(Long id, Event updatedEvent) {
        return eventRepository.findById(id).map(event -> {
            event.setTitle(updatedEvent.getTitle());
            event.setDescription(updatedEvent.getDescription());
            event.setDate(updatedEvent.getDate());
            event.setTime(updatedEvent.getTime());
            event.setVenue(updatedEvent.getVenue());
            event.setImageUrl(updatedEvent.getImageUrl());  // Use imageUrl instead of image
            return eventRepository.save(event);
        }).orElseThrow(() -> new RuntimeException("Event not found with id " + id));
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    // New method to get an event by ID
    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }
}
