package com.example.liftoffproject.controllers;

import com.example.liftoffproject.models.data.MenuDao;
import com.example.liftoffproject.models.data.VenueDao;
import com.example.liftoffproject.models.forms.AddVenueMenuForm;
import com.example.liftoffproject.models.forms.Venue;
import com.example.liftoffproject.models.forms.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.validation.Valid;



@Controller
@RequestMapping("venue")
public class VenueController {

    @Autowired
    VenueDao venueDao;

    @Autowired
    MenuDao menuDao;

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("venues", venueDao.findAll());
        model.addAttribute("title", "Venues");

        return "venue/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("title", "Add Venue");
        model.addAttribute("venue", new Venue());

        return "venue/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model,
                      @ModelAttribute @Valid Venue venue, Errors errors) {
        if (errors.hasErrors()) {
            return "venue/add";
        }

        venueDao.save(venue);
        return "redirect:view/" + venue.getId();
    }

    @RequestMapping(value="view/{venueId}", method = RequestMethod.GET)
    public String viewVenue(Model model, @PathVariable int venueId){

        Venue venue = venueDao.findById(venueId).orElse(null);

        model.addAttribute("title", venue.getName());
        model.addAttribute("menus", venue.getMenus());
        model.addAttribute("venueId", venue.getId());

        return "venue/view";
    }

    @RequestMapping(value="add-menu/{venueId}", method = RequestMethod.GET)
    public String addMenu(Model model, @PathVariable int venueId){

        Venue venue = venueDao.findById(venueId).orElse(null);

        AddVenueMenuForm form = new AddVenueMenuForm(menuDao.findAll(), venue);
        model.addAttribute("title", "Add menu to venue:");
        model.addAttribute("form", form);

        return "venue/add-menu";
    }

    @RequestMapping(value="add-menu", method = RequestMethod.POST)
    public String addMenu(Model model,
                           @ModelAttribute @Valid AddVenueMenuForm form, Errors errors) {
        if(errors.hasErrors()){
            model.addAttribute("form", form);
            return "venue/add-menu";
        }
        Menu theMenu = menuDao.findById(form.getMenuId()).orElse(null);
        Venue theVenue = venueDao.findById(form.getVenueId()).orElse(null);
        theVenue.addMenu(theMenu);
        venueDao.save(theVenue);

        return "redirect:/venue/view/" + theVenue.getId();
    }
}
