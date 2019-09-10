package org.launchcode.july2019ryan.controllers;

import org.launchcode.july2019ryan.forms.Venue;
import org.launchcode.july2019ryan.models.MenuDao;
import org.launchcode.july2019ryan.models.VenueDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@RequestMapping(value="venue")
public class VenueController {

    @Autowired
    VenueDao venueDao;

    @Autowired
    MenuDao menuDao;

    @RequestMapping(value="")
    public String index(Model model){
        model.addAttribute("venues", venueDao.findAll());

        return "venue/index";
    }

    @RequestMapping(value="add", method= RequestMethod.GET)
    public String addVenue(Model model){
        model.addAttribute(new Venue());

        return "venue/add";
    }

    @RequestMapping(value="add", method = RequestMethod.POST)
    public String addVenue(Model model, @ModelAttribute @Valid Venue venue, Errors errors){
        if(errors.hasErrors()){
            return "venue/add";
        }
        venueDao.save(venue);

        return "redirect:venue/" + venue.getId();
    }

    @RequestMapping(value="view/{venueId}", method = RequestMethod.GET)
    public String viewMenu(Model model, @PathVariable int venueId) {

        Venue venue = venueDao.findById(venueId).orElse(null);
        model.addAttribute("menu", venue.getMenus());
        model.addAttribute("venueId", venue.getId());

        return "venue/view";
    }
}
