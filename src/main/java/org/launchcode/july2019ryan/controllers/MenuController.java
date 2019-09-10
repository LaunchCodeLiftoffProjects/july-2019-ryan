package org.launchcode.july2019ryan.controllers;


import org.launchcode.july2019ryan.forms.Menu;
import org.launchcode.july2019ryan.models.ItemDao;
import org.launchcode.july2019ryan.models.MenuDao;
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
@RequestMapping(value="menu")
public class MenuController {

    @Autowired
    ItemDao itemDao;

    @Autowired
    MenuDao menuDao;

    @RequestMapping(value="")
        public String index(Model model) {
        model.addAttribute("menus", menuDao.findAll());
        return "menu/index";
        }

    @RequestMapping(value="add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(new Menu());
        return "menu/add";
    }

    @RequestMapping(value ="add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid Menu menu, Errors errors) {
        if(errors.hasErrors()) {
            return "menu/add";
        }
        menuDao.save(menu);
        return "redirect:view/" + menu.getId();
    }

    @RequestMapping(value="view/{menuId}", method = RequestMethod.GET)
    public String viewMenu(Model model, @PathVariable int menuId) {

        Menu menu = menuDao.findById(menuId).orElse(null);
        model.addAttribute("items", menu.getItems());
        model.addAttribute("menuId", menu.getId());

        return "menu/view";

    }



}
