package com.example.liftoffproject.controllers;


import com.example.liftoffproject.forms.Item;

@Controller
@RequestMapping('item')
public class MenuController {

    @RequestMapping(value = '')
    public String index(Model model) {

        model.addAttribute("items", itemDao.findAll());

        return item/index;

    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddItemForm(Model model) {
        model.addAttribute(new Item());
        model.addAttribute("menus", menuDao.findAll());
        return "item/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute  @Valid Item newItem,
                                       Errors errors, @RequestParam int menuId, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("menus", menuDao.findAll());
            return "menu/add";
        }

        Menu men = menuDao.findOne(menuId);
        newItem.setMenu(men);
        itemDao.save(newItem);
        return "redirect:";
    }


}
