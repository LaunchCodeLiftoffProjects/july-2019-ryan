package com.example.liftoffproject.controllers;

import com.example.liftoffproject.models.data.GenreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;


@Controller
@RequestMapping("Genre")
public class GenreController {

    @Autowired
    GenreDao genreDao;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model, @RequestParam(defaultValue = "0") int id) {
        model.addAttribute("title", "Genres");
        model.addAttribute("Genres", GenreDao.findAll());
        return "genre/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(new Genre());
        model.addAttribute("title", "Add Genre");
        return "genre/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid Genre genre, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Genre");
            return "genre/add";
        }

        GenreDao.save(genre);
        return "redirect:";
    }}

