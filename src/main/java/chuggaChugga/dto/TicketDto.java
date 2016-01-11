package chuggaChugga.dto;
import chuggaChugga.domain.TicketDataSet;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class TicketDto {

    private int id;
    private String train;
    private UserDto user;
    private String arrivalStation;
    private String departureStation;
    private LocalDateTime departureDateTime;
    private LocalDateTime arrivalDateTime;

    public TicketDto(){}

    public TicketDto(TicketDataSet ticket, LocalDateTime departureDateTime, LocalDateTime arrivalDateTime) {
        id = ticket.getId();
        train = ticket.getTrain().getName();
        user = UserDto.newBuilder(ticket.getUser()).build();
        arrivalStation = ticket.getArrivalStation();
        departureStation = ticket.getDepartureStation();
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;
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

    public LocalDateTime getDepartureDateTime() {
        return departureDateTime;
    }

    public String getDepartureDateTimeString() {
        return departureDateTime.toString(DateTimeFormat.longDateTime());
    }

    public String getDepartureDateString() {
        return departureDateTime.toString(DateTimeFormat.longDate());
    }

    public LocalDateTime getArrivalDateTime() {
        return arrivalDateTime;
    }

    public String getArrivalDateTimeString() {
        return arrivalDateTime.toString(DateTimeFormat.longDateTime());
    }
}
