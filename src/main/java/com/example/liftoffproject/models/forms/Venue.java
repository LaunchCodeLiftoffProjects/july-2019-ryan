package com.example.liftoffproject.models.forms;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Venue {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=15)
    private String name;

    @NotNull
    @Size(min=1, message = "description needs to be filled in")
    private String description;

    @NotNull
    @Size(min=1, message = "address needs to be filled in")
    private String address;

    @NotNull
    @Size(min=1, message = "phone needs to be filled in")
    private String phone;

    @NotNull
    @Size(min=1, message = "parking needs to be filled in")
    private String parking;

    @NotNull
    @Size(min=1, message = "seating needs to be filled in")
    private String seating;

    @OneToMany
    @JoinColumn(name = "venue_id")
    private List<Event> events = new ArrayList<>();

    public Venue() {}

    public Venue(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getId() {

        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getParking() {
        return parking;
    }

    public void setParking(String parking) {
        this.parking = parking;
    }

    public String getSeating() {
        return seating;
    }

    public void setSeating(String seating) {
        this.seating = seating;
    }

    public List<Event> getEvents() { return events; }
}
