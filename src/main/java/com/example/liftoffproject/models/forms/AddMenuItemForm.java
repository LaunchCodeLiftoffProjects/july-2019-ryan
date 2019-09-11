package com.example.liftoffproject.models.forms;

import javax.validation.constraints.NotNull;

public class AddMenuItemForm {

    @NotNull
    private int menuId;

    @NotNull
    private int itemId;

    private Iterable<Item> items;

    private Menu menu;

    public AddMenuItemForm(Iterable<Item> items, Menu menu) {
        this.items = items;
        this.menu = menu;
    }

    public AddMenuItemForm() {}

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public Iterable<Item> getItems() {
        return items;
    }

    public void setItems(Iterable<Item> items) {
        this.items = items;
    }

    public Menu getMenu() {
        return menu;
    }
}
