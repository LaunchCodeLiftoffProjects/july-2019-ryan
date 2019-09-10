package org.launchcode.july2019ryan.forms;



import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class Menu {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=15)
    private String name;

    @ManyToMany
    private List<Item> items=new ArrayList<>();

    public Menu(){}

    public Menu(String name) {this.name=name;}

    public int getId() { return id;}

    public String getName() { return name;}
    public void setName(String name) {this.name = name;}

    public List<Item> getItems() { return items; }
    public void addItem(Item item) { items.add(item);}
}
