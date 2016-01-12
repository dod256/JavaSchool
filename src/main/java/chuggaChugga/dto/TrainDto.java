package chuggaChugga.dto;

import chuggaChugga.domain.RouteStationDataSet;
import chuggaChugga.domain.TrainDataSet;
import chuggaChugga.data.Route;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;

public class TrainDto {

    private int id;
    private String name;
    Route route;
    private LocalDateTime departureDate;
    private int numberOfSeats;
    private int numberOfFreeSeats;
    private int cost;

    public TrainDto(){}

    public TrainDto(TrainDataSet train, Route trainRoute) {
        id = train.getId();
        name = train.getName();
        departureDate = new LocalDateTime(train.getDepartureDate());
        numberOfSeats = train.getNumberOfSeats();
        numberOfFreeSeats = train.getNumberOfFreeSeats();
        cost = train.getCost();
        route = trainRoute;
    }

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

    public RouteStationDataSet getDepartureRouteStation() {
        return route.getRouteStations().get(0);
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

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public String getDepartureDateString() {return departureDate.toString(DateTimeFormat.longDate()); }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public int getNumberOfFreeSeats() {
        return numberOfFreeSeats;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "TrainDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", route=" + route +
                ", departureDate=" + departureDate +
                ", numberOfSeats=" + numberOfSeats +
                ", numberOfFreeSeats=" + numberOfFreeSeats +
                ", cost=" + cost +
                '}';
    }
}
