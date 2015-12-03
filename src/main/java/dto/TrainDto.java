package main.java.dto;

import main.java.Entities.Station;
import main.java.Entities.Train;
import main.java.data.Route;
import org.joda.time.DateTime;

public class TrainDto {

    public int getId() {
        return id;
    }

    public Route getRoute() {
        return route;
    }

    public String getName() {
        return name;
    }

    public String getDepartureStation() {
        return route.getStations().get(0).getName();
    }

    public String getDepartureStationTime() {
        return route.getRouteStations().get(0).getArrival().toString();
    }

    public String getArrivalStation() {
        return route.getStations().get(route.getStations().size() - 1).getName();
    }

    public String getArrivalStationTime() {
        return route.getRouteStations().get(route.getStations().size() - 1).getArrival().toString();
    }

    public DateTime getDepartureDate() {
        return departureDate;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public int getNumberOfFreeSeats() {
        return numberOfFreeSeats;
    }

    public int getCost() {
        return cost;
    }

    private int id;
    private String name;
    Route route;
    private DateTime departureDate;
    private int numberOfSeats;
    private int numberOfFreeSeats;
    private int cost;

    public TrainDto(){}

    public TrainDto(Train train, Route trainRoute) {
        id = train.getId();
        name = train.getName();
        departureDate = new DateTime(train.getDepartureDate());
        numberOfSeats = train.getNumberOfSeats();
        numberOfFreeSeats = train.getNumberOfFreeSeats();
        cost = train.getCost();
        route = trainRoute;
    }

    //ToDo add some magic
    public DateTime getArrivalTime(Station station) {
        return null;
    }

}
