package main.java.data;

import main.java.Entities.Station;

import java.util.ArrayList;

public class Route {

    private ArrayList<Station> stations;
    private int routeId;

    public ArrayList<Station> GetStations() {
        return stations;
    }

    public int getId() {
        return routeId;
    }

}
