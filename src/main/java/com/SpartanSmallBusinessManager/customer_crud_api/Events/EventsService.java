package com.SpartanSmallBusinessManager.customer_crud_api.Events;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventsService {

    @Autowired
    private EventsRepository eventsRepository;

    public List<Events> getAllEvents() {
        return eventsRepository.findAll();
    }

    public Events getEventById(int eventId) {
        return eventsRepository.findById(eventId).orElse(null);
    }

    public void addNewEvent(Events event) {
        eventsRepository.save(event);
    }

    public void updateEvent(int eventId, Events event) {
        Events existing = getEventById(eventId);
        if (existing != null) {
            existing.setEventName(event.getEventName());
            existing.setEventDescription(event.getEventDescription());
            existing.setEventLocation(event.getEventLocation());
            existing.setEventDate(event.getEventDate());
            eventsRepository.save(existing);
        }
    }

    public void deleteEventById(int eventId) {
        eventsRepository.deleteById(eventId);
    }
}
