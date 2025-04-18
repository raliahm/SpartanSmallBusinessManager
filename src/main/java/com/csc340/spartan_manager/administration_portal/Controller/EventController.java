package com.csc340.spartan_manager.administration_portal.Controller;


import com.csc340.spartan_manager.administration_portal.Entity.Event;
import com.csc340.spartan_manager.administration_portal.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * EventController.java.
 * Includes all REST API endpoint mappings for the Event object.
 */
@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService service;

    /**
     * Get a list of all Events in the database.
     * http://localhost:8080/events/all
     *
     * @return a list of Event objects.
     */
    @GetMapping("/all")
    public Object getAllEvents() {
        return new ResponseEntity<>(service.getAllEvents(), HttpStatus.OK);
    }

    /**
     * Create a new Event entry.
     * http://localhost:8080/events/new
     *
     * @param event the new Event object.
     * @return confirmation message.
     */
    @PostMapping("/new")
    public Object addNewEvent(@RequestBody Event event) {
        service.addNewEvent(event);
        return new ResponseEntity<>("New Event Successfully Created!", HttpStatus.CREATED);
    }

    /**
     * Update an existing Event object.
     * http://localhost:8080/events/update/2
     *
     * @param eventId the unique Event Id.
     * @param event   the updated Event details.
     * @return the updated Event object.
     */
    @PutMapping("/update/{eventId}")
    public Object updateEvent(@PathVariable int eventId, @RequestBody Event event) {
        service.updateEvent(eventId, event);
        return new ResponseEntity<>(service.getEventById(eventId), HttpStatus.CREATED);
    }

    /**
     * Delete an Event object.
     * http://localhost:8080/events/delete/2
     *
     * @param eventId the unique Event Id.
     * @return the updated list of Events.
     */
    @DeleteMapping("/delete/{eventId}")
    public Object deleteEventById(@PathVariable int eventId) {
        service.deleteEventById(eventId);
        return new ResponseEntity<>(service.getAllEvents(), HttpStatus.OK);
    }
}
