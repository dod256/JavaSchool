package chuggaChugga.dto;

import chuggaChugga.model.Ticket;
import chuggaChugga.service.RouteService;
import chuggaChugga.service.RouteServiceImpl;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TicketDto {

    private int id;
    private String train;
    private UserDto user;
    private String arrivalStation;
    private String departureStation;
    private DateTime departureDate;


    public TicketDto(){}

    public TicketDto(Ticket ticket) {
        id = ticket.getId();
        train = ticket.getTrain().getName();
        user = new UserDto(ticket.getUser());
        arrivalStation = ticket.getArrivalStation();
        departureStation = ticket.getDepartureStation();
        departureDate = new DateTime(ticket.getTrain().getDepartureDate());
    }

    public int getId() {
        return id;
    }

    public String getTrain() {
        return train;
    }

    public UserDto getUser() {
        return user;
    }

    public String getArrivalStation() {
        return arrivalStation;
    }

    public String getDepartureStation() {
        return departureStation;
    }

    public DateTime getDepartureDate() {
        return departureDate;
    }

    public String getDepartureDateString() {
        return departureDate.toString(DateTimeFormat.longDate());
    }

}
