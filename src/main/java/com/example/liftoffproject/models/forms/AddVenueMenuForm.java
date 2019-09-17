package com.example.liftoffproject.models.forms;

import javax.validation.constraints.NotNull;

public class AddVenueMenuForm {

    @NotNull
    private int venueId;

    @NotNull
    private int menuId;

    private Iterable<Menu> menus;

    private Venue venue;

    public AddVenueMenuForm(Iterable<Menu> menus, Venue venue) {
        this.menus = menus;
        this.venue = venue;
    }

    public AddVenueMenuForm(){}


    public int getVenueId() {
        return venueId;
    }

    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public Iterable<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Iterable<Menu> menus) {
        this.menus = menus;
    }

    public Venue getVenue() {
        return venue;
    }

}
