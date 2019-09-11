package com.example.liftoffproject.controllers;


import com.example.liftoffproject.models.data.EventDao;
import com.example.liftoffproject.models.data.VenueDao;
import com.example.liftoffproject.models.forms.Event;
import com.example.liftoffproject.models.forms.Venue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("event")
public class EventController {

    @Autowired
    EventDao eventDao;

    @Autowired
    VenueDao venueDao;

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("events", eventDao.findAll());
        model.addAttribute("title", "Events");

        return "event/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddEventForm(Model model) {
        model.addAttribute("title", "Add Event");
        model.addAttribute(new Event());
        model.addAttribute("venues", venueDao.findAll());
        return "event/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddEventForm(@ModelAttribute @Valid Event newEvent,
                                      Errors errors, @RequestParam int venueId, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Event");
            model.addAttribute("venues", venueDao.findAll());
            return "event/add";
        }

        Venue ven = venueDao.findById(venueId).orElse(null);;
        newEvent.setVenue(ven);
        eventDao.save(newEvent);
        return "redirect:";

    }

    @RequestMapping(value = "venue", method = RequestMethod.GET)
    public String venue(Model model, @RequestParam int id) {

        Venue ven = venueDao.findById(id).orElse(null);;
        List<Event> events = ven.getEvents();
        model.addAttribute("events", events);
        model.addAttribute("title", "Events in Venue: " + ven.getName());
        return "event/index";
    }

}