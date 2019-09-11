package com.example.liftoffproject.controllers;

import com.example.liftoffproject.models.data.ItemDao;
import com.example.liftoffproject.models.forms.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("item")
public class ItemController {

    @Autowired
    ItemDao itemDao;

    @RequestMapping(value="")
    public String index(Model model) {
        model.addAttribute("items", itemDao.findAll());

        return "item/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddItemForm(Model model) {
        model.addAttribute(new Item());
        return "item/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddItemForm(@ModelAttribute @Valid Item newItem,
                                     Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "item/add";

        }

        itemDao.save(newItem);
        return "redirect:";
    }

}
