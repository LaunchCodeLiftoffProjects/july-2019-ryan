package org.launchcode.july2019ryan.forms;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
    @Size(min=1, message="what is the name of your event")
    private String name;

    @NotNull
    @Size(min=1, message="description needs to not be empty")
    private String description;

    @NotNull
    @Size(min=1, message="address needs to not be empty")
    private String address;

    @NotNull
    @Size(min=7, max=11)
    private String phone;

    @NotNull
    @Size(min=1, message="let us know how much parking you have")
    private String parking;

    @NotNull
    @Size(min=1, message="what is the seating type")
    private String seating;

    @ManyToMany
    private List<Menu> menus=new ArrayList<>();

    public Venue(String name, String description, String address, String phone, String parking, String seating){
        this.name=name;
        this.description=description;
        this.address=address;
        this.phone=phone;
        this.parking=parking;
        this.seating=seating;

    }

    public Venue(){}


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<Menu> getMenus() { return menus; }
    public void addMenu(Menu menu) { menus.add(menu);}
}
