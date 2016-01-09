package chuggaChugga.dto;
import chuggaChugga.model.TicketDataSet;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class TicketDto {



    //ToDo add fields: LocalDateTime departureDateTime, arrivalDateTime
    //     delete fields: DateTime departureDate
    //     add methods: getDeparture(Date, Time or DateTime)(w\o String)
    //     delete methods: connected to departureDate
    //     and refactor Builder

    private int id;
    private String train;
    private UserDto user;
    private String arrivalStation;
    private String departureStation;
    private DateTime departureDate;


    public TicketDto(){}

    public TicketDto(TicketDataSet ticket) {
        id = ticket.getId();
        train = ticket.getTrain().getName();
        user = UserDto.newBuilder(ticket.getUser()).build();
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
