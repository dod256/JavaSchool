package main.java.dto;

import main.java.Entities.Station;

import java.util.ArrayList;

public class RouteDto {

    private ArrayList<Station> route;
    private int routeId;

    public ArrayList<Station> GetStations() {
        return route;
    }

    public int getId() {
        return routeId;
    }

}
