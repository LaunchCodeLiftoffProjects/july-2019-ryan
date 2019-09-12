package com.example.liftoffproject.controllers;

import com.example.liftoffproject.models.data.VenueDao;
import com.example.liftoffproject.models.forms.Venue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.validation.Valid;



@Controller
@RequestMapping("venue")
public class VenueController {

    @Autowired
    private VenueDao venueDao;

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
        return "redirect:";
    }
}
