package main.java.builders;

import main.java.Entities.Station;

public class StationBuilder {

    private String name;


    public StationBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public Station createStation() {
        return new Station(name);
    }
}