package com.csc340.spartan_manager.administration_portal.Service;

import com.csc340.spartan_manager.administration_portal.Entity.Event;
import com.csc340.spartan_manager.administration_portal.Repository.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EntityUpdateEntryService updateLogger;


    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getEventById(int eventId) {
        return eventRepository.findById(eventId).orElse(null);
    }

    public void addNewEvent(Event event) {
        eventRepository.save(event);
        updateLogger.logUpdate(event.getEventId(), "INSERT", "events", "", "", "", "Created new event");

    }

    public void updateEvent(int eventId, Event newEvent) {
        Event existing = getEventById(eventId);
        if (existing != null) {
            if (!existing.getEventName().equals(newEvent.getEventName())) {
                updateLogger.logUpdate(eventId, "UPDATE", "events", "name",
                        existing.getEventName(), newEvent.getEventName(),  "Event name updated");
                existing.setEventName(newEvent.getEventName());
            }

            if (!existing.getEventDescription().equals(newEvent.getEventDescription())) {
                updateLogger.logUpdate(eventId, "UPDATE", "events", "description",
                        existing.getEventDescription(), newEvent.getEventDescription(), "Event description updated");
                existing.setEventDescription(newEvent.getEventDescription());
            }

            if (!existing.getEventLocation().equals(newEvent.getEventLocation())) {
                updateLogger.logUpdate(eventId, "UPDATE", "events", "location",
                        existing.getEventLocation(), newEvent.getEventLocation(), "Event location updated");
                existing.setEventLocation(newEvent.getEventLocation());
            }


            eventRepository.save(existing);
        }
    }


    public void deleteEventById(int eventId) {
        updateLogger.logUpdate(eventId, "DELETE", "Event", "", "", "", "Deleted event");
        eventRepository.deleteById(eventId);
    }

    public List<Event> getRecentEvents() {
        return eventRepository.findTop5ByOrderByEventDateDesc(); // Query the database for recent events
    }
}