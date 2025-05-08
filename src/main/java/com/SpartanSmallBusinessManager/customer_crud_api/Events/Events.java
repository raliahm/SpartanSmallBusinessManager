package com.SpartanSmallBusinessManager.customer_crud_api.Events;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
@Table(name= "events")
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventId;

    @Column(nullable = false)
    private String eventName;

    private String eventDescription;

    private String eventLocation;

    private char eventDate;


    public Events() {}

    public Events(String eventName, String eventDescription, String eventLocation, char eventDate) {
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.eventLocation = eventLocation;
        this.eventDate = eventDate;

    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public char getEventDate() {
        return eventDate;
    }

    public void setEventDate(char eventDate) {
        this.eventDate = eventDate;
    }

}

