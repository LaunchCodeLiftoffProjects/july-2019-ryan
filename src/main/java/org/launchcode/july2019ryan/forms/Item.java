package org.launchcode.july2019ryan.forms;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Item {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=15)
    private String name;

    @NotNull
    @Size(min=1, message = "Description needs to not be empty")
    private String description;

    @ManyToMany(mappedBy = "items")
    private List<Menu> menus;

    public Item(String name, String description){
        this.name = name;
        this.description = description;
    }

    public Item(){}

    public int getId() { return id;}

    public String getName() { return name;}
    public void setName(String name) {this.name =name;}

    public String getDescription(){ return description;}
    public void setDescription(String description) {this.description = description;}


}
