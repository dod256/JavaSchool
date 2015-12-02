package main.java.dto;

import main.java.Entities.Ticket;
import main.java.services.RouteService;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

public class TicketDto {

    private int id;
    private TrainDto train;
    private UserDto user;
    private int routeNumberOfArrivalStation;
    private int routeNumberOfDepartureStation;
    private DateTime departureDate;

    //ToDo innerBuilder
    public TicketDto(){}

    public TicketDto(Ticket ticket) {
        id = ticket.getId();
        train = new TrainDto(ticket.getTrain(), RouteService.getRouteById(ticket.getTrain().getDepartureStation().getRouteId()));//ToDo maybe another way to do THIS
        user = new UserDto(ticket.getUser());
        routeNumberOfArrivalStation = ticket.getRouteNumberOfArrivalStation();
        routeNumberOfDepartureStation = ticket.getRouteNumberOfDepartureStation();
        departureDate = new DateTime(ticket.getTrain().getDepartureDate());
    }

    public int getId() {
        return id;
    }

    public TrainDto getTrain() {
        return train;
    }

    public UserDto getUser() {
        return user;
    }

    public int getRouteNumberOfArrivalStation() {
        return routeNumberOfArrivalStation;
    }

    public int getRouteNumberOfDepartureStation() {
        return routeNumberOfDepartureStation;
    }

    public DateTime getDepartureDate() {
        return departureDate;
    }

    public String getDepartureDateString() {
        return departureDate.toString(DateTimeFormat.longDate());
    }

}
