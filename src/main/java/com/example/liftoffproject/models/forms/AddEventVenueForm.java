package com.example.liftoffproject.models.forms;

import javax.validation.constraints.NotNull;

public class AddEventVenueForm {

    @NotNull
    private int venueId;

    @NotNull
    private int eventId;

    private Iterable<Venue> venues;

    private Event event;

    public AddEventVenueForm(Iterable<Venue> venues, Event event) {
        this.venues = venues;
        this.event = event;
    }

    public AddEventVenueForm(){}


    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getVenueId() {
        return venueId;
    }

    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }

    public Iterable<Venue> getVenues() {
        return venues;
    }

    public void setVenues(Iterable<Venue> venues) {
        this.venues = venues;
    }

    public Event getEvent() {
        return event;
    }

}
