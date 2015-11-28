package main.java.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Station {

    private int id;
    @Id
    private String name;

    public Station() {}

    public Station(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
