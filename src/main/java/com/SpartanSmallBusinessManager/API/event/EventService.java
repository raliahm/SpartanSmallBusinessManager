package com.SpartanSmallBusinessManager.API.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getEventById(int eventId) {
        return eventRepository.findById(eventId).orElse(null);
    }

    public void addNewEvent(Event event) {
        eventRepository.save(event);
    }

    public void updateEvent(int eventId, Event event) {
        Event existing = getEventById(eventId);
        if (existing != null) {
            existing.setEventName(event.getEventName());
            existing.setEventDescription(event.getEventDescription());
            existing.setEventLocation(event.getEventLocation());
            existing.setEventDate(event.getEventDate());
            existing.setProvider(event.getProvider());
            eventRepository.save(existing);
        }
    }

    public void deleteEventById(int eventId) {
        eventRepository.deleteById(eventId);
    }
}
