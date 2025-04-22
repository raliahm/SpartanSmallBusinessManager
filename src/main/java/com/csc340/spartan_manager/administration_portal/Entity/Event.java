package com.csc340.spartan_manager.administration_portal.Entity;


import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventId;

    @Column(nullable = false)
    private String eventName;

    private String eventDescription;

    private String eventLocation;

    private LocalDate eventDate;

    @ManyToOne
    @JoinColumn(name = "provider_id", nullable = false)
    private ProviderUser provider;

    private Timestamp createdDate;

    public Event() {}

    public Event(String eventName, String eventDescription, String eventLocation, LocalDate eventDate, ProviderUser provider, Timestamp createdDate) {
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.eventLocation = eventLocation;
        this.eventDate = eventDate;
        this.provider = provider;
        this.createdDate = createdDate;
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

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public ProviderUser getProvider() {
        return provider;
    }

    public void setProvider(ProviderUser provider) {
        this.provider = provider;
    }
    public Timestamp getCreatedAt() {
        return createdDate;
    }


    public void setCreatedAt(Timestamp createdAt) {
        this.createdDate = createdAt;
    }
}