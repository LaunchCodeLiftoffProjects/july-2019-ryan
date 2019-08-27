package com.example.liftoffproject.forms;


import com.sun.istack.internal.NotNull;


public class Item {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=30)
    private String name;

    @NotNull
    @Size(min=1, message = "A description is needed")
    private String description;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public Item() { }

    public int getId() { return id; }

    public String getName(){ return name; }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }


}
