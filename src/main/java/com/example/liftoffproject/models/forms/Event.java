package com.example.liftoffproject.models.forms;

import com.sun.istack.internal.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;


@Entity
public class Event {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=15)
    private String name;

    @NotNull
    private Date date;

    @NotNull
    private BigDecimal price;

    @NotNull
    @Size(min=3, max=15)
    private String genre;

    @NotNull
    @Size(min=1, max=50)
    private String artist;

    @ManyToOne
    private Venue venue;

    public Event(String name, Date date, BigDecimal price, String genre, String artist) {
        this.name = name;
        this.date = date;
        this.price = price;
        this.genre = genre;
        this.artist = artist;

    }

    public Event() { }

    public int getId() { return id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getGenre() { return genre; }

    public void setGenre(String genre) { this.genre = genre; }

    public String getArtist() { return artist; }

    public void setArtist(String artist) { this.artist = artist; }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    public BigDecimal getPrice() { return price; }

    public void setPrice(BigDecimal price) { this.price = price; }

    public Venue getVenue() { return venue; }

    public void setVenue(Venue venue) { this.venue = venue; }
}

