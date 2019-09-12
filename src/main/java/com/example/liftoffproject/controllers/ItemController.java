package com.example.liftoffproject.controllers;

import com.example.liftoffproject.models.data.ItemDao;
import com.example.liftoffproject.models.data.MenuDao;
import com.example.liftoffproject.models.forms.Item;
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
@RequestMapping("item")
public class ItemController {

    @Autowired
    ItemDao itemDao;

    @Autowired
    MenuDao menuDao;

    @RequestMapping(value="")
    public String index(Model model) {
        model.addAttribute("items", itemDao.findAll());
        model.addAttribute("title", "My Items");

        return "item/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddItemForm(Model model) {
        model.addAttribute("title", "Add Item");
        model.addAttribute(new Item());
        model.addAttribute("menus", menuDao.findAll());
        return "item/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddItemForm(@ModelAttribute @Valid Item newItem,
                                     Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Item");
            model.addAttribute("menus", menuDao.findAll());
            return "item/add";

        }

        itemDao.save(newItem);
        return "redirect:";
    }

}

