package com.example.liftoffproject.controllers;


import com.example.liftoffproject.models.data.EventDao;
import com.example.liftoffproject.models.data.VenueDao;
import com.example.liftoffproject.models.forms.AddEventVenueForm;
import com.example.liftoffproject.models.forms.Event;
import com.example.liftoffproject.models.forms.Venue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;


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
        return "event/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddEventForm(Model model, @ModelAttribute @Valid Event event,
                                      Errors errors ) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Event");
            return "event/add";
        }


        eventDao.save(event);
        return "redirect:view/" + event.getId();

    }

    @RequestMapping(value="view/{eventId}", method = RequestMethod.GET)
    public String viewEvent(Model model, @PathVariable int eventId){

        Event event = eventDao.findById(eventId).orElse(null);

        model.addAttribute("title", event.getName());
        model.addAttribute("venues", event.getVenues());
        model.addAttribute("eventId", event.getId());

        return "event/view";
    }

    @RequestMapping(value="add-venue/{eventId}", method = RequestMethod.GET)
    public String addVenue(Model model, @PathVariable int eventId){

        Event event = eventDao.findById(eventId).orElse(null);

        AddEventVenueForm form = new AddEventVenueForm(venueDao.findAll(), event);
        model.addAttribute("title", "Add venue to event:");
        model.addAttribute("form", form);

        return "event/add-venue";
    }

    @RequestMapping(value="add-venue", method = RequestMethod.POST)
    public String addVenue(Model model,
                           @ModelAttribute @Valid AddEventVenueForm form, Errors errors) {
        if(errors.hasErrors()){
            model.addAttribute("form");
            return "event/add-venue";
        }

        Venue theVenue = venueDao.findById(form.getVenueId()).orElse(null);
        Event theEvent = eventDao.findById(form.getEventId()).orElse(null);
        theEvent.addVenue(theVenue);
        eventDao.save(theEvent);

        return "redirect:/event/view/" + theEvent.getId();
    }

}