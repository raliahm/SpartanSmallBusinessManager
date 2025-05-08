package com.SpartanSmallBusinessManager.API.event;

import com.SpartanSmallBusinessManager.API.provider.Provider;
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

    public List<Event> getAllEventsForProvider(Provider provider) {
        return eventRepository.findByProvider(provider);
    }

    public Event getEventById(int eventId) {
        return eventRepository.findById(eventId).orElse(null);
    }

    public void addNewEvent(Event event) {
        eventRepository.save(event);
    }

    public void updateEvent(int eventId, Event updatedEvent) {
        Event existing = getEventById(eventId);
        if (existing != null) {
            existing.setEventName(updatedEvent.getEventName());
            existing.setEventDescription(updatedEvent.getEventDescription());
            existing.setEventLocation(updatedEvent.getEventLocation());
            existing.setEventDate(updatedEvent.getEventDate());
            existing.setProvider(updatedEvent.getProvider());
            eventRepository.save(existing);
        }
    }

    public void deleteEventById(int eventId) {
        eventRepository.deleteById(eventId);
    }
}
